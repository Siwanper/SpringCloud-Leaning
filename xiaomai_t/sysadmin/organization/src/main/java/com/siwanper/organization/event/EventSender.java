package com.siwanper.organization.event;

import com.siwanper.organization.config.BusConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 描述:
 * 消息发送事件
 *
 * @outhor ios
 * @create 2020-04-29 10:44 AM
 */
@Slf4j
@Component
public class EventSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;
    // 初始化方法
    @PostConstruct
    public void init(){
        rabbitTemplate.setMessageConverter(messageConverter);
    }
    // 发送消息
    public void send(String routingKey, Object object){
        log.info("routingKey: {},  send message: {} ", routingKey, object);
        rabbitTemplate.convertAndSend(BusConfig.EXCHANGE_NAME, routingKey, object);
    }
}
