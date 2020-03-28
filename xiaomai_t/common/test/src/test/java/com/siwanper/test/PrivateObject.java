package com.siwanper.test;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-28 10:15 AM
 */
public class PrivateObject {

    private String code;

    public String getCode(){
        return code;
    }

    private String changeCode(String code) {
        this.code = code;
        return code;
    }

    private void changeCode(){
        this.code = "aaaa";
    }



}
