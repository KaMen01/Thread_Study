package com.km.study.thread.t4_Join.fight_task;

import java.util.List;

/**接口
 * 注意无论是Thread类和Runnable类都是返回void的
 * 所以如果你想要线程返回结果，还是需要自己来定义接口返回的结果
 * @author coming
 * @date 2021/10/25 21:48
 */
public interface FightQuery {
    /**查询航班的结果
     *
     * @return 结果集
     */
    public List<String> get();
}
