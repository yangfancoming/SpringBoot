package com.goat.C.C08.item02;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---15:52
 */

public class SleepingState extends State {

    @Override
    public void writeProgram(Work work) {
        System.out.println("当前时间" + work.getHour() + "不行了，睡着了");
    }
}
