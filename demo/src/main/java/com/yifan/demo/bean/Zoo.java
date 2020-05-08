package com.yifan.demo.bean;

public class Zoo {
    private Monkey monkey;
    private Tiger tiger;

    public Monkey getMonkey() {
        return monkey;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

    public Tiger getTiger() {
        return tiger;
    }

    public void setTiger(Tiger tiger) {
        this.tiger = tiger;
    }

    @Override
    public String toString() {
        return "Tiger:"+tiger+", Monkey:" + monkey;
    }
}
