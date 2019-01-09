package com.crk.lock.nonreentrantLock;

import java.util.concurrent.atomic.AtomicReference;

public class UnreentrantLock {

    private AtomicReference<Thread> owner = new AtomicReference<Thread>();

    public void lock() {
		Thread current = Thread.currentThread();
		//这句是很经典的“自旋”语法，AtomicInteger中也有
		for (;;) {
			if (!owner.compareAndSet(null, current)) {
				System.out.println(current.getName());
            }
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }

	public static void main(String[] args) {
		UnreentrantLock lock = new UnreentrantLock();
		lock.lock();
		lock.lock();
	}
}
