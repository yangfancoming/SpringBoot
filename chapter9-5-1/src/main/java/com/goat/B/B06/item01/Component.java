package com.goat.B.B06.item01;

import java.util.List;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description:  Component 抽象组件：为 组合模式中的 所有对象提供一个接口，不管是叶子对象还是组合对象。
 * @ author  山羊来了
 * @ date 2019/7/15---20:53
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void operation(String str);

    public void add(Component c) {
        throw new UnsupportedOperationException();
    }

    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    public Component getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public List<Component> getChildren() {
        return null;
    }
}