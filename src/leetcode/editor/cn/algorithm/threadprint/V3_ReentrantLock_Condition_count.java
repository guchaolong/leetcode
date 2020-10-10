package leetcode.editor.cn.algorithm.threadprint;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 三个线程顺序打印A B C
 *
 * @author AA
 * @date 2020/10/10 13:49
 */
public class V3_ReentrantLock_Condition_count {

    private static int count = 0;

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition print_a = lock.newCondition();
        Condition print_b = lock.newCondition();
        Condition print_c = lock.newCondition();


        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    //每次要打印前都判断一下，是否可以打印，如果不可以，就等待
                    while (count % 3 != 2) {
                        print_c.await();
                    }
                    System.out.println("C");
                    count++;
                    print_a.signal();//打印完了，通知下一个
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1) {
                        print_b.await();
                    }
                    System.out.println("B");
                    count++;
                    print_c.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0) {
                        print_a.await();//print.wait()是继承自Object的
                    }
                    System.out.println("A");
                    count++;
                    print_b.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


    }
}
