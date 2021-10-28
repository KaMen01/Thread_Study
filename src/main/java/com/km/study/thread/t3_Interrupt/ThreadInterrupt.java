package com.km.study.thread.t3_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author coming
 * @date 2021/10/5 9:47
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
                System.out.println("hahaha~");
            } catch (InterruptedException e) {
                //当阻塞的线程被interrupt时，它会抛出InterruptedException异常
                //这个异常就像一个signal一样通知当前线程被打断了
                System.out.println("被interrupt了");
            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
