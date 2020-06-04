package com.siwanper.gateway.web.event;

import com.siwanper.gateway.web.service.IRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventReceiver {

    @Autowired
    private IRouteService routeService;

    public void handleMessage(Object object){
        log.info("Received Message:<{}>", object);
        if (object instanceof RouteDefinition) {
            RouteDefinition routeDefinition = (RouteDefinition) object;
            routeService.save(routeDefinition);
        } else if (object instanceof String) {
            String routeId = (String) object;
            routeService.delete(routeId);
        }

    }

}
