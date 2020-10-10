package leetcode.editor.cn.algorithm.threadprint;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 三个线程交替顺序打印ABC
 *
 * @author AA
 * @date 2020/10/10 16:08
 */
public class V2_Lock_State {

    //起始位置，因为是在lock.lock()后，所以是线程安全的，多线程可以state++
    private static int state = 0;

    public static void main(String[] args) throws Exception {

        Lock lock = new ReentrantLock();

        Runnable a = () -> {

            int count = 10;
            while (count > 0) {
                try {
                    lock.lock();//每次打印都要加锁，因为没使用await 不会停下
                    while (state % 3 == 0) {
                        System.out.println("A");
                        count--;
                        state++;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };


        Runnable b = () -> {
            int count = 10;
            while (count > 0) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.println("B");
                        count--;
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        };


        Runnable c = () -> {
            int count = 10;
            while (count > 0) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.println("C");
                        count--;
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        };

        new Thread(c).start();
        new Thread(b).start();
        new Thread(a).start();

    }
}
