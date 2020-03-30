package com.siwanper.test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-30 10:09 AM
 */
public class CommonsLangTest {

    @Test
    public void stringUtilTest(){

        String a = "123";
        String b = " ";

        System.out.println(StringUtils.isEmpty(a)); // false
        System.out.println(StringUtils.isEmpty(b)); // false


        System.out.println(StringUtils.isBlank(a)); // false
        System.out.println(StringUtils.isBlank(b)); // true

        String c = "  ab  c  ";

        System.out.println(StringUtils.trim(c)); // ab  c
        System.out.println(StringUtils.deleteWhitespace(c)); //abc
        System.out.println(StringUtils.strip(c)); // ab  c

        String d = "abc";
        String e = "ABC";

        System.out.println(StringUtils.equals(d,e)); // false
        System.out.println(StringUtils.equalsIgnoreCase(d, e)); // true

        System.out.println(StringUtils.replace(d, "bc","df")); // adf

        String f = "aabccaabcc";

        System.out.println(StringUtils.indexOf(f, "b")); // 2

        System.out.println(StringUtils.contains(f, "abc")); // true

        System.out.println(StringUtils.substring(f, 4)); // caabcc

        System.out.println(StringUtils.reverse(f)); // ccbaaccbaa

        String g= "a,b,c";
        String[] strings = StringUtils.split(g, ","); // 分割字符串
        System.out.println(strings[1]);

        System.out.println(StringUtils.join(strings, ";")); // a;b;c

        System.out.println(StringUtils.upperCase(g)); // A,B,C
        System.out.println(StringUtils.lowerCase(e)); // abc

        System.out.println(StringUtils.isAlpha(f)); // 是否都是字符串

        System.out.println(StringUtils.isNumeric(f)); // 是否都是数字

    }


}
