package leetcode.editor.cn.algorithm.threadprint;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Description: 三个线程交替顺序打印ABC
 *
 * @author AA
 * @date 2020/10/10 12:52
 */
public class V1_Sync_Notify_Wait {

    public static void main(String[] args) throws Exception {


        Object obj_a = new Object();
        Object obj_b = new Object();
        Object obj_c = new Object();

        /*
        A B C对应3个对象
        a线程需要获得C的锁，再获得A的锁，然后打印，通知在A上等待的线程，继续等待获取C的锁
        b线程需要获得A的锁，再获得B的锁，然后打印，通知在B上等待的线程，继续等待获取A的锁
        c线程需要获得B的锁，再获得C的锁，然后打印，通知在B上等待的线程，继续等待获取C的锁

        通过Thread.sleep(10)控制初始顺序 ABC

         */


        Runnable a = () -> {
            int count = 10;
            while (count > 0) {
                synchronized (obj_c) {
                    synchronized (obj_a) {
                        System.out.println("A");
                        count--;
                        obj_a.notifyAll();
                    }
                    try {
                        //打完最后一次之后就不需要在等待了
                        if (count > 0) {
                            obj_c.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable b = () -> {
            int count = 10;
            while (count > 0) {
                synchronized (obj_a) {
                    synchronized (obj_b) {
                        System.out.println("B");
                        count--;
                        obj_b.notifyAll();
                    }
                    try {
                        if (count > 0) {
                            obj_a.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Runnable c = () -> {
            int count = 10;
            while (count > 0) {
                synchronized (obj_b) {
                    synchronized (obj_c) {
                        System.out.println("C");
                        count--;
                        obj_c.notifyAll();
                    }
                    try {
                        if (count > 0) {
                            obj_b.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        //控制初始顺序
        new Thread(a).start();
        Thread.sleep(10);
        new Thread(b).start();
        Thread.sleep(10);
        new Thread(c).start();
        Thread.sleep(10);


    }
}
