package com.ahui.creationpattern.singletonpattern;

/**
 * @Author: ahui
 * @Description: 单例模式
 * @DateTime: 2022/5/12 - 17:09
 **/
public class SingletonDemo {
    /**
     * 声明全局对象的引用 volatile 关键字保证对象内部变化的可见性，让使用该单例的所有对象能共享内部的变化;
     */
    private volatile static SingletonDemo instance;

    /**
     * 私有化构造方法防止外部实例
     */
    private SingletonDemo() {}

    /**
     * 获取实例
     * @return SingLetonDemo对象的实例
     */
    public static SingletonDemo getInstance() {
        if(instance == null) {
            //采用类级同步锁 防止不同对象之间的竞争
            synchronized (SingletonDemo.class) {
                if(instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
    public void showMessage() {
        System.out.println("This is a singleton pattern!");
    }
}

class Test {
    public static void main(String[] args) {
        SingletonDemo instance = SingletonDemo.getInstance();
        instance.showMessage();
    }
}