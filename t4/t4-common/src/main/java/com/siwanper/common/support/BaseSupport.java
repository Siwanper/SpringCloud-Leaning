package com.siwanper.common.support;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class BaseSupport {

    /**
     * 判断对象是否为空 或 为null
     * @param obj
     * @return
     */
    public boolean isNull(Object obj) {
        if (null == obj)
            return true;
        if (obj instanceof List){
            List<?> list = (List<?>) obj;
            return list.isEmpty() ? true : false;
        }
        if (obj instanceof Map){
            Map<?, ?> map = (Map<?, ?>) obj;
            return map.isEmpty() ? true : false;
        }
        if (obj instanceof Set){
            Set<?> set = (Set<?>) obj;
            return set.isEmpty() ? true : false;
        }
        return false;
    }

    /**
     * 将对象转为字符串
     * @param obj
     * @return
     */
    public String obj2Str(Object obj) {
        return null == obj ? "" : obj.toString();
    }

    /**
     * 获取UUID，32 位，并为大写
     * @return
     */
    public String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 对字符串进行 base64 编码
     * @param str
     * @return
     */
    public String base64Encoder(String str){
        if (this.isNull(str)) {
            return null;
        }
        return Base64.getUrlEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 对字符串 base64 解码
     * @param str
     * @return
     */
    public String base64Decoder(String str){
        if (this.isNull(str)) {
            return null;
        }
        return new String(Base64.getUrlDecoder().decode(str), StandardCharsets.UTF_8);
    }

    /**
     * 对字符串进行MD5加密
     * @param str
     * @return
     */
    public String md5(String str){
        if (this.isNull(str)){
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(str.getBytes());
            return new BigInteger(1,md.digest()).toString(16).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前系统时间
     * @param pattern 时间格式 如："yyyy-MM-dd hh:mm:ss"
     * @return
     */
    public String currentDate(String pattern){
        if (this.isNull(pattern)){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date());
    }

    /**
     * 时间戳转换为日期
     * @param timeStamp 时间戳
     * @param pattern 日期格式
     * @return
     */
    public String timeStamp2Date(String timeStamp, String pattern){
        if (this.isNull(timeStamp) || this.isNull(pattern)){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date(Long.valueOf(timeStamp)));
    }

    /**
     * 日期转换为时间戳
     * @param dateStr 日期
     * @param pattern 日期格式
     * @return
     */
    public String date2TimeStamp(String dateStr, String pattern){
        if (this.isNull(dateStr) || this.isNull(pattern)){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return String.valueOf(dateFormat.parse(dateStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从指定文件路径读取文件
     * @param filePath 文件路径
     * @return
     */
    public String readFromFile(String filePath){
        if (this.isNull(filePath)){
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            File file = new File(filePath);
            FileReader reader = new FileReader(file);
            char[] bb = new char[1024]; // 用来存储每次读取到的字符
            int n;
            while ((n = reader.read(bb)) != -1){
                stringBuffer.append(new String(bb, 0, n));
            }
            reader.close(); // 关闭输入流，释放链接
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将内容写入到指定文件内
     * @param content
     * @param filePath
     */
    public void writeToFile(String content, String filePath){
        if (!this.isNull(content) && !this.isNull(filePath)){
            generateFile(filePath);
            File file = new File(filePath);
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(content);
                writer.flush(); // 清空缓存区域，立即写入到指定文件
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成文件
     * @param filePath
     */
    public void generateFile(String filePath){
        if (!this.isNull(filePath)){
            File file = new File(filePath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成文件夹
     * @param path
     */
    public void generateDirectroy(String path){
        if (!this.isNull(path)){
            File file = new File(path);
            if (!file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
        }
    }

    /**
     * 读取 配置信息 , 在classpath 下的 /properties/setting.properties 中
     * @param key
     * @return
     */
    public String propertiesValue(String key){
        if (this.isNull(key)){
            return null;
        }
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream("/properties/setting.properties");
        try {
            properties.load(stream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取配置信息
     * @param resource 资源文件路径（在classpath下）
     * @param key      资源对应的key
     * @return
     */
    public String propertiesValue(String resource, String key){
        if (this.isNull(resource) || this.isNull(key)){
            return null;
        }
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream(resource);
        try {
            properties.load(stream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
