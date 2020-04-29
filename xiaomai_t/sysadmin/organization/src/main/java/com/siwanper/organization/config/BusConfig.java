package com.siwanper.organization.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: 配置消息队列
 *
 * @outhor ios
 * @create 2020-04-29 10:30 AM
 */
@Configuration
@Slf4j
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
        log.info("binding queue: {}, exchange:{} , withRoutingkey: {}", QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY_NAME);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_NAME);
    }

    // 以Json个是发送消息
    @Bean
    public MessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
    }


}
