package test;

import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " & 1 = " + (i & 1));
        }
    }

    /**
     * 测试基本用法
     */
    private void fun1() {
        String name1 = Thread.currentThread().getName();
        System.out.println(System.currentTimeMillis() + ": " + name1 + " fun1()");
        lock.lock();
        System.out.println(System.currentTimeMillis() + ": " + name1 + " 获取到锁");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    /**
     * 测试基本用法2
     */
    private void fun2() {
        lock.tryLock();
    }
}
