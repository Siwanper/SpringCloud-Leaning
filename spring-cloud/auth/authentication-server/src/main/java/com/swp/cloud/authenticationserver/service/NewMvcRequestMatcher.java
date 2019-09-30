package com.swp.cloud.authenticationserver.service;

import com.google.common.base.Objects;
import lombok.Getter;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 11:40 AM
 */
@Getter
public class NewMvcRequestMatcher extends MvcRequestMatcher {

    private String pattern;
    private String method;

    public NewMvcRequestMatcher(HandlerMappingIntrospector introspector, String pattern, String method) {
        super(introspector, pattern);
        this.setMethod(HttpMethod.resolve(method));
        this.pattern = pattern;
        this.method = method;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj){
            return true;
        }

        if (null == obj || obj.getClass() != this.getClass()) {
            return false;
        }

        NewMvcRequestMatcher that = (NewMvcRequestMatcher) obj;

        return Objects.equal(this.pattern, that.pattern) && Objects.equal(that.method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pattern, method);
    }
}
