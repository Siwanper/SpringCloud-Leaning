package com.swp.cloud.common.web.interceptor;


import com.swp.cloud.common.core.entity.po.BasePo;
import com.swp.cloud.common.core.util.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Properties;

/**
 * 描述:
 * mybatis执行拦截器
 *
 * 默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：

 Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 ParameterHandler (getParameterObject, setParameters)
 ResultSetHandler (handleResultSets, handleOutputParameters)
 StatementHandler (prepare, parameterize, batch, update, query)

 * @outhor ios
 * @create 2019-09-02 5:16 PM
 */

@Component
@Intercepts(value = {@Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class})})
@Slf4j
public class AuditInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        DefaultParameterHandler parameterHandler = (DefaultParameterHandler) invocation.getTarget();

        if (parameterHandler.getParameterObject() instanceof BasePo) {
            BasePo param = (BasePo) parameterHandler.getParameterObject();
            String username = StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), BasePo.DEFAULT_USERNAME);
            log.debug("mybatis intercept fill username:{}", username);
            param.setCreatedBy(username);
            param.setCreatedTime(new Date());
            param.setUpdatedBy(username);
            param.setUpdatedTime(new Date());
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
