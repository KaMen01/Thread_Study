package com.km.study.thread.t4_Join.fight_task;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**线程任务
 *
 * @author coming
 * @date 2021/10/25 21:49
 */
public class FightQueryTask extends Thread implements FightQuery {
    private final String origin;

    private final String destination;

    private final List<String> flightList = new ArrayList<>();

    public FightQueryTask(String ariline,String origin, String destination) {
        super("["+ariline+"]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.printf("%s-query from %s to %s \n",getName(),origin,destination);
        int randomVal = ThreadLocalRandom.current().nextInt(10);

        try {
            //假设查询需要的随机秒数
            TimeUnit.SECONDS.sleep(randomVal);

            //假设查询出来的几架飞机
            this.flightList.add(getName()+"-"+randomVal);
            System.out.printf("The Fight:%s list query successful\n",getName());
        } catch (InterruptedException e) {
        }
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
