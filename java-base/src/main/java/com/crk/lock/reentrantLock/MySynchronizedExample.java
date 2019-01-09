package com.crk.lock.reentrantLock;

/**
 * Created by kunlyy on 2019/1/9.
 */
public class MySynchronizedExample {

    public synchronized void doSomething() {
        System.out.println("methoe doSomething");
    }
    public static void main(String[] args) {
        MySynchronizedExample example = new MySynchronizedExample();
        example.doSomething();
        example.doSomething();
    }

}
