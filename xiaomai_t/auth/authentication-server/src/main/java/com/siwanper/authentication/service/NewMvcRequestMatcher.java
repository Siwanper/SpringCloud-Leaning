package com.siwanper.authentication.service;

import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.Objects;

/**
 * 描述: 请求对比器，当请求url和method一样，则判断请求相同。
 *
 * @outhor ios
 * @create 2020-04-28 3:04 PM
 */
@Data
public class NewMvcRequestMatcher extends MvcRequestMatcher {

    // url
    private String pattern;
    // 请求方式
    private String method;

    public NewMvcRequestMatcher(HandlerMappingIntrospector introspector, String pattern, String method) {
        super(introspector, pattern);
        this.setMethod(HttpMethod.resolve(method));
        this.pattern = pattern;
        this.method = method;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        NewMvcRequestMatcher that = (NewMvcRequestMatcher) object;
        return Objects.equals(pattern, that.pattern) &&
                Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, method);
    }
}
