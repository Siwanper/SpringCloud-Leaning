package com.siwanper.authentication.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siwanper.authentication.event.EventReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-29 11:39 AM
 */
@Slf4j
@Configuration
public class BusConfig {

    public static final String QUEUE_NAME = "ORGANIZATION_QUEUE";
    public static final String EXCHANGE_NAME = "ORGANIZATION_EXCAHNGE";
    public static final String ROUTING_KEY_NAME = "ORGANIZAITON_ROUTING_KEY";

    // 创建队列
    @Bean
    public Queue queue(){
        log.info("init queue : {}", QUEUE_NAME);
        return new Queue(QUEUE_NAME);
    }

    // 创建交换机
    @Bean
    public TopicExchange exchange(){
        log.info("init exchange : {}", EXCHANGE_NAME);
        return new TopicExchange(EXCHANGE_NAME);
    }

    // 将队列与交换机绑定
    @Bean
    public Binding bindQueue2ExchangeWithRoutingKey(Queue queue, TopicExchange exchange){
        log.info("binding queue: {}, exchange:{} , withRoutingkey: {}", queue.getName(), EXCHANGE_NAME, ROUTING_KEY_NAME);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_NAME);
    }

    /**
     * 消息监听容器
     *
     * 绑定指定队列和消息适配器
     *
     * @param connectionFactory
     * @param messageListenerAdapter
     * @param queue
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter, Queue queue){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(queue.getName());
        simpleMessageListenerContainer.setMessageListener(messageListenerAdapter);
        return simpleMessageListenerContainer;
    }

    /**
     * 消息适配器
     *
     * 设置消息接受代理，默认代理方法为 handleMessage
     * 设置消息接受数据类型。
     *
     * @param receiver 接受代理
     * @param messageConverter
     * @return
     */
    @Bean
    public MessageListenerAdapter messageListenerAdapter(EventReceiver receiver, MessageConverter messageConverter){
        return new MessageListenerAdapter(receiver, messageConverter);
    }

    /**
     *  接受消息类型一定要和消息发送类型一致，不然会报异常
     *  MessageConverter 为统一消息转化类型
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
    }

}
