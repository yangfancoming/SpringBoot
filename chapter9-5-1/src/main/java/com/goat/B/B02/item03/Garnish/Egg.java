package com.goat.B.B02.item03.Garnish;

import com.goat.B.B02.item03.base.Pancake;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: 煎蛋
 * @ author  山羊来了
 * @ date 2019/5/13---9:04
 */
public class Egg extends Garnish {

    private Pancake pancake;

    public Egg(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 煎蛋";
    }

    @Override
    public double price() {
        return pancake.price() + 2;
    }

}