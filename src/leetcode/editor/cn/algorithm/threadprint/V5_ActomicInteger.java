package leetcode.editor.cn.algorithm.threadprint;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/10 17:28
 */
public class V5_ActomicInteger {
    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(0);

        new Thread(()->{
            int count = 10;
            while (count > 0){
                if(ai.get() % 3 == 0){
                    System.out.println("A");
                    count--;
                    ai.getAndIncrement();
                }
            }
        }).start();
        new Thread(()->{
            int count = 10;
            while (count > 0){
                if(ai.get() % 3 == 1){
                    System.out.println("B");
                    count--;
                    ai.getAndIncrement();
                }
            }
        }).start();
        new Thread(()->{
            int count = 10;
            while (count > 0){
                if(ai.get() % 3 == 2){
                    System.out.println("C");
                    count--;
                    ai.getAndIncrement();
                }
            }
        }).start();
    }
}
