package com.siwanper.product.event.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "PRODUCT_QUEUE")
public class ProductListener {

    @RabbitHandler
    public void receiveMessge(Object object){
        log.info("listener : {}", object);
    }
}
