package com.swp.cloud.authenticationserver.event;

import com.swp.cloud.sysadmin.organization.entity.po.Resource;
import com.swp.cloud.authenticationserver.service.IResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-30 10:36 AM
 */
@Component
@Slf4j
public class BusReceiver {

    @Autowired
    private IResourceService resourceService;

    public void handleMessage(Resource resource) {
        log.info("Received Message:<{}>", resource);
        resourceService.saveResource(resource);
    }
}
