package com.swp.cloud.authorizationserver.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.swp.cloud.common.core.entity.vo.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-27 11:49 AM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {

    private final Result result;

    CustomOauthException(OAuth2Exception exception) {
        super(exception.getSummary(), exception);
        this.result = Result.fail(AuthErrorType.valueOf(exception.getOAuth2ErrorCode().toUpperCase()), exception);
    }

}
