package com.siwanper.resttemplate;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResttemplateApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void get(){
        String result = restTemplate.getForObject("http://localhost:8010/user/{id}", String.class, "101");
        System.out.printf(result);
    }

    @Test
    public void post(){
        String url = "http://localhost:8010/user/search";
        JSONObject param = new JSONObject();
        param.put("page","1");
        param.put("size","10");
        ResponseEntity<JSONObject> entity = restTemplate.postForEntity(url, param, JSONObject.class);
        System.out.printf("code:" + entity.getStatusCode() +" header: " + entity.getHeaders() + " body : " + entity.getBody());
    }

    @Test
    public void headerAndCookie(){
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl("http://localhost:8010").path("/user/search")
                .build(true);
        URI uri = uriComponents.toUri();

        JSONObject param = new JSONObject();
        param.put("page","1");
        param.put("size","10");

        RequestEntity<JSONObject> entity = RequestEntity.post(uri)
                .header("headerkey","headerValue")
                .header(HttpHeaders.COOKIE, "cookieKey=cookieValue")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(param);
        ResponseEntity<JSONObject> result = restTemplate.exchange(entity, JSONObject.class);
        System.out.printf("code:" + result.getStatusCode() +" header: " + result.getHeaders() + " body : " + result.getBody());
    }

    @Test
    public void upload(){

    }

}
