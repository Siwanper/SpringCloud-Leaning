package com.swp.serviceb.service.hystrix;

import com.swp.serviceb.service.ProducerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * DESCRIPTION：   ${DESCRIPTION}
 *
 * @ProjectName: spring-cloud-module
 * @Package: com.swp.serviceb.service.hystrix
 * @Author: Siwanper
 * @CreateDate: 2019/7/1 下午11:28
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
@Component
public class ProducerServiceCallBack implements ProducerService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Producer can't be used";
    }
}
