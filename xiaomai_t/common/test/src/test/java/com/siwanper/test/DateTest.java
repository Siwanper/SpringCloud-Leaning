package com.siwanper.test;

import org.junit.Test;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-30 11:13 AM
 */
public class DateTest {

    @Test
    public void currentTime(){

        long l = System.currentTimeMillis();
        System.out.println(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date(l);
        System.out.println(dateFormat.format(date));

        System.out.println(dateFormat.format(new Date()));
        System.out.println(new Date().getTime());
    }

    @Test
    public void localDate(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter.format(localDate));
    }

    @Test
    public void localTime(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(formatter.format(localTime));
    }

    @Test
    public void localDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter.format(localDateTime));
    }

    @Test
    public void zoneDateTime(){
        ZonedDateTime dateTime = ZonedDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateTime.format(formatter));

    }
}
