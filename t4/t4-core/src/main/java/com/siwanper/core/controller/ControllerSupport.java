package com.siwanper.core.controller;

import com.siwanper.api.persistence.DelegateService;
import com.siwanper.common.model.MsgModel;
import com.siwanper.common.model.PageModel;
import com.siwanper.common.support.BaseSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class ControllerSupport extends BaseSupport {

    @Autowired
    private DelegateService delegateService;

    /**
     * 获取通用的Mapper对象。
     * @return
     */
    protected DelegateService getService(){
        return delegateService;
    }

    /**
     * 返回分页查询的对象
     * @param list 查询结果
     * @param <T> 查询对象
     * @return
     */
    protected <T> PageModel<T> resultPage(List<T> list){
        return new PageModel(list);
    }

    /**
     * 返回请求结果模型
     * @param status 状态
     * @param message 结果描述
     * @param object 返回结果
     * @return
     */
    protected MsgModel resultMsg(String status, String message, Object object){
        return new MsgModel(status, message, object);
    }

    /**
     * 返回请求结果模型
     * @param status 请求状态
     * @param message 结果描述
     * @return
     */
    protected MsgModel resultMsg(String status, String message){
        return new MsgModel(status, message);
    }

    /**
     * 返回请求结果模型
     * @param message 结果描述
     * @return
     */
    protected MsgModel resultMsg( String message){
        return new MsgModel(message);
    }




}
