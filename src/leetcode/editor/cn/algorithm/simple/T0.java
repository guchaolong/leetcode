/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/4/30 1.0          guchaolong          Creation File
 */
package leetcode.editor.cn.algorithm.simple;

import java.util.Scanner;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/4/30 14:21
 */
public class T0 {

    /**
     * 兔子问题
     * 1 1 2 3 5 8
     */
    public static void rabbit(int m) {
        int f1 = 1, f2 = 1, f3;
        for (int i = 1; i <= m; i++) {
            if (i <= 2) {
                System.out.println("第" + i + "个月兔子有1对");
                continue;
            }
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            System.out.println("第" + i + "个月兔子有" + f3 + "对");
        }
    }

    public static int rabbit2(int m) {
        if (m <= 2) {
            return 1;
        }
        return rabbit2(m - 1) + rabbit2(m - 2);
    }

    /**
     * 101-200之间的素数
     */
    public static void prime() {
        int sum = 0;
        for (int i = 101; i < 201; i++) {
            boolean b = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    b=false;
                    break;
                }
            }
            if (b){
                sum++;
                System.out.print(i + " ");
                if (sum % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * 水仙花数
     * 153 = 1的3次方+5的3次方+3的3次方
     */
    public static void flower() {
        int i, j, k;
        int n;
        for (n = 100; n < 1000; n++) {
            i = n / 100;//百位
            j = n % 100 / 10;//十位
            k = n % 10;//个位
            if (n == i * i * i + j * j * j + k * k * k) {
                System.out.println(n);
            }
        }
    }

    /**
     * 分解质因子
     * 如 90 = 2*3*3*5
     */
    public static void fen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数:");
        int num = sc.nextInt();
        //int num = 90;
        int k = 2;
        System.out.print(num + "=");//输出第一步格式
        while (num >= k) {//初值k为2,num为输入的数字,在程序执行的过程中k渐渐变大(k++),num渐渐变小(num/k)
            if (num == k) {
                System.out.println(k);
                break;
            } else if (num % k == 0) {
                System.out.print(k + "×");//如果num <> k，但n能被k整除，则应打印出k的值
                num = num / k;//num除以k的商,作为新的正整数你num
            } else {
                k++;
            }
        }
    }


    /**
     * 两个数的最小公倍数 和最大公约数
     */
    public static void zxgy() {
        System.out.println("请输入两个数：");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int a, b, temp;
        if (num1 < num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        a = num1;
        b = num2;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        System.out.println("最大公约数：" + a);
        System.out.println("最小公倍数" + num1 * num2 / a);
    }


    public static void main(String[] args) {
//        rabbit(20);
//        System.out.println(rabbit2(20));
        prime();
        flower();
        fen();
//        zxgy();
    }
}