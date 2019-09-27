package com.swp.cloud.authorizationserver.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import java.io.IOException;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-27 12:11 PM
 */
public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {

    CustomOauthExceptionSerializer(){
        super(CustomOauthException.class);
    }

    @Override
    public void serialize(CustomOauthException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(e.getResult());
    }
}
