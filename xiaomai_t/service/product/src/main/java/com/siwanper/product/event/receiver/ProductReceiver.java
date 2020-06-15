package com.siwanper.product.event.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductReceiver {

    public void handleMessage(Object object){
        log.info("receiver : {}", object);
    }

}
