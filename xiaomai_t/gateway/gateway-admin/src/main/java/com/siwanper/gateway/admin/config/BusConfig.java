package com.siwanper.gateway.admin.config;

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

@Configuration
@Slf4j
public class BusConfig {

    public static final String QUEUR_NAME = "GATEWAY_ROUTE_QUEUE";
    public static final String EXCHANGE_NAME = "GATEWAY_ROUTE_EXCHANGE";
    public static final String ROUTING_KEY = "GATEWAY_ROUTING_KEY";
    public static final String ROUTING_KEY_DELETE = "GATEWAY_ROUTING_KEY_DELETE";

    @Bean
    public Queue queue(){
        log.info("init queue : {}", QUEUR_NAME);
        return new Queue(QUEUR_NAME);
    }

    @Bean
    public TopicExchange exchange(){
        log.info("init exchange: {}", EXCHANGE_NAME);
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingQueueToExchange(Queue queue, TopicExchange exchange){
        log.info("binding queue:{} to exchange:{} with routingkey:{}", QUEUR_NAME, EXCHANGE_NAME, ROUTING_KEY);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingQueueToExchangeDelete(Queue queue, TopicExchange exchange){
        log.info("binding queue:{} to exchange:{} with routingkey:{}", QUEUR_NAME, EXCHANGE_NAME, ROUTING_KEY_DELETE);
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_DELETE);
    }

    @Bean
    public MessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
    }

}
