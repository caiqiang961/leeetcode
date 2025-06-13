package org.jindonmainshi;


import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class Main1 {
    private final AtomicInteger result = new AtomicInteger(0);
    private final LongAdder result1 = new LongAdder();

    private final ThreadLocal<Integer> threadLocalCount = ThreadLocal.withInitial(() -> 0);
    private final AtomicInteger result2 = new AtomicInteger(0);

    private volatile int result3 = 0;
    private volatile int result4 = 0;

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        Main1 main1 = new Main1();
        main1.sum();
        main1.sum1();
        main1.sum2();
        main1.sum3();
//        main1.sum4();
        Thread.sleep(2000);
        System.out.println(main1.result);
        System.out.println(main1.result1);
        System.out.println(main1.result2);
        System.out.println(main1.result3);
        System.out.println(main1.result4);
    }

    // 方法一：使用AtomicInteger的cas操作
    private void sum() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    result.incrementAndGet();
                    // 这个是错误的result.compareAndSet(result.get(),result.get()+1); ， result.get()不是原子操作
//                    result.compareAndSet(result.get(),result.get()+1);
                }
            });
            t.start();
        }
    }

    // 方法二：使用LongAdder的cas操作
    private void sum1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    result1.increment();
                }
            });
            t.start();
        }
    }

    // 使用theadLocal先并发修改自己的++，最后使用AtomicInteger的cas操作合并每个线程的++
    private void sum2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    threadLocalCount.set(threadLocalCount.get() + 1);
                }
                result2.getAndAdd(threadLocalCount.get());
            });
            t.start();
        }
    }

    private void sum3() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    // 虽然cas加锁了，但锁内并没有执行+操作，只是执行了比较和赋值操作
                    cas();
                }
            });
            t.start();

        }
    }

    private void cas() {
        while (true) {
            int curr = result3;
            int n = curr + 1;
            synchronized (this) {
                if (result3 == curr) {
                    result3 = n;
                    break;
                }
            }
        }
    }
//
//    private void sum4() throws IllegalAccessException, NoSuchFieldException {
////        Unsafe unsafe = Unsafe.getUnsafe();
//        // 反射获取 Unsafe 实例
//        Field unsafeF = Unsafe.class.getDeclaredField("theUnsafe");
//        unsafeF.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeF.get(null);
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(() -> {
//                for (int j = 0; j < 10000; j++) {
//                    try {
//                        int valueOffset = (int) unsafe.objectFieldOffset
//                                 (this.getClass().getDeclaredField("value"));
//                        int curr = result4;
//                        unsafe.compareAndSwapInt(this,valueOffset,curr,curr+1);
//                    } catch (NoSuchFieldException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//            });
//            t.start();
//
//        }
//    }

}
