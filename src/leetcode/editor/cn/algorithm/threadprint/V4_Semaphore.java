package leetcode.editor.cn.algorithm.threadprint;

import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/10 17:13
 */
public class V4_Semaphore {
    public static void main(String[] args) {

        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);
        Semaphore C = new Semaphore(0);

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();//A获取一个信号量，A的信号量减1 为0时无法再获取
                    System.out.println("A");
                    B.release();//A获取之后给B加一个信号量
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();//最开始为0，获取不到，A执行完之后才能获取到
                    System.out.println("B");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();//最开始为0，获取不到，B执行完之后才能获取到
                    System.out.println("C");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
