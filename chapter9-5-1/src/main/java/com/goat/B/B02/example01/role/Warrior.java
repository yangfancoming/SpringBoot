package com.goat.B.B02.example01.role;

import com.goat.B.B02.example01.base.IRole;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 战士
 * @ author  山羊来了
 * @ date 2019/4/26---15:05
 */
public class Warrior implements IRole {
    //防御力
    private float defense = 20f;
    //攻击力
    private float power = 20f;
    //描述
    private String describe = "战士";

    @Override
    public String getDescribe() {
        return describe;
    }

    @Override
    public float getPower() {
        return power;
    }

    @Override
    public float getDefense() {
        return defense;
    }
}