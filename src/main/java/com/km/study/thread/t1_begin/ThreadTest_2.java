package com.km.study.thread.t1_begin;

public class ThreadTest_2 {

    static class TicketWindowRunnable implements Runnable{

        private int index=1;
        private final  static int Max = 500;
        public void run() {
            while(index<=Max){
                System.out.println(Thread.currentThread().getName()+" 的号码是："+index++);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable task = new TicketWindowRunnable();
        Thread thread = new Thread(task,"我的id是啥");
//        Class<? extends Thread> aClass = thread.getClass()

        new Thread(task,"1号").start();
        new Thread(task,"2号").start();
        new Thread(task,"3号").start();
        new Thread(task,"4号").start();

    }
}
