package com.siwanper.authentication.event;

import com.siwanper.organization.entity.po.Resource;
import com.siwanper.authentication.service.IResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 消息接受事件
 *
 * @outhor ios
 * @create 2020-04-29 10:52 AM
 */
@Slf4j
@Component
public class EventReceiver {

    @Autowired
    private IResourceService resourceService;

    /**
     *  handleMessage 为消息接受默认代理方法
     * @param resource
     */
    public void handleMessage(Resource resource){
        log.info("receive resource: {}" ,resource);
        resourceService.saveResource(resource);
    }

}
