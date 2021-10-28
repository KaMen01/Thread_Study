package com.km.study.thread.t2_Group;

/**
 * @author coming
 * @date 2021/10/3 20:35
 * @description 测试线程池
 */
public class ThreadGroup01 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");

        ThreadGroup threadGroup = new ThreadGroup("tg1");
        Thread t2 = new Thread(threadGroup, "t2");

        System.out.println("main thread belong group:"+Thread.currentThread().getThreadGroup().getName());

        System.out.println("t1 thread belong group:"+t1.getThreadGroup().getName());

        System.out.println("t2 thread belong group:" + t2.getThreadGroup().getName());

    }

}
