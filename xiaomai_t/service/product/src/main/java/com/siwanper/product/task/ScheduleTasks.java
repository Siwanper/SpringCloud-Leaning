package com.siwanper.product.task;

import com.siwanper.product.config.BusConfig;
import com.siwanper.product.event.sender.ProductSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@EnableScheduling
@Component
public class ScheduleTasks {

    @Autowired
    private ProductSender sender;

    @Scheduled(fixedRate = 3000)
    public void send(){
        sender.sender(BusConfig.ROUTING_KEY, "Hello Product");
    }

}
