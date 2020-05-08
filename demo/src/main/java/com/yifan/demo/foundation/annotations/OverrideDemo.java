/*
 * Author     : shaofan
 * Date       : 5/7/2020 12:12 PM
 * Description:
 *
 */

package com.yifan.demo.foundation.annotations;

import org.springframework.context.annotation.Bean;

public class OverrideDemo {
    public void testOverride() {
        System.out.println("without override:");
        Animal animal = new Animal();
        animal.show();
        System.out.println("Dog without override!");
        Animal dog = new Dog();
        dog.show();
        Dog dog1 = new Dog();
        dog1.show();

        System.out.println("Cat with override!");
        Animal cat = new Cat();
        cat.show();
        Cat cat1 = new Cat();
        cat1.show();
        System.out.println("all completed!");

        System.out.println("Override实际没什么用，只是会自动检查父类是否存在此方法，如果没有会报错；\n如果修改父类方法名时会提示，仅此而已。\n同时标注为final的方法不允许使用此注解。");
    }
}

class Animal {
    void show() {
        System.out.println("show in animal class!");
    }
}

class Dog extends Animal {
    void show() {
        System.out.println("show in dog, method without override.");
    }
}

class Cat extends Animal {
    void show() {
        System.out.println("show in cat, method with override.");
    }
}