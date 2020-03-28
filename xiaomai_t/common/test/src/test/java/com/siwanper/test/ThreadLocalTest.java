package com.siwanper.test;

import org.junit.Test;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-28 12:38 PM
 */
public class ThreadLocalTest {

    @Test
    public void test(){
        ThreadLocalRunable runable = new ThreadLocalRunable();

        Thread thread = new Thread(runable);
        Thread thread1 = new Thread(runable);

        thread.start();
        thread1.start();
    }

}
