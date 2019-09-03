package com.swp.cloud.common.test;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-03 4:40 PM
 */
public class PrivateObject {

    private String code;

    public String getCode() {
        return code;
    }

    private void changeCode(String  code) {
        this.code = code;
    }

    private String changeCode(){
        this.code = "22222";
        return this.code;
    }
}
