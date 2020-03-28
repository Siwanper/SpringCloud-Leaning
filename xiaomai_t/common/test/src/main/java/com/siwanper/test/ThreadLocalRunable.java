package com.siwanper.test;

/**
 * 描述:ThreadLocal 保存的数据只能被同一个线程读写。
 *
 * @outhor ios
 * @create 2020-03-28 12:35 PM
 */
public class ThreadLocalRunable implements  Runnable{

    private ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public void run() {

        threadLocal.set((int)(Math.random()*100D));
        System.out.println("ThreadLocal get value : " + threadLocal.get());

    }
}
