package com.km.study.thread.t1_begin;

import java.util.concurrent.TimeUnit;

//Thread的简单使用
public class ThreadTest_1 {
    private Integer index = 1;

    public static void main(String[] args) {
        /*browseNews();
        enjoyMusic();*/
        new Thread("TestThreadNews"){
            @Override
            public void run() {
                browseNews();
            }
        }.start();
        enjoyMusic();

    }

    private static void browseNews(){
        for (;;) {
            System.out.println("看新闻，哇！这个新闻正好看");
            sleep(1);
        }

    }

    private static void enjoyMusic(){
        for(;;){
            System.out.println("欣赏音乐🎵~");
            sleep(1);
        }
    }


    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
