/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: Algorithm
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/1 1.0          guchaolong          Creation File
 */
package leetcode.editor.cn.algorithm.sort;

import java.util.Arrays;

/**
 * Description: 插入排序
 *
 * @author guchaolong
 * @date 2019/6/1 20:51
 */
public class InsertSort {
    /**
     * 直接插入排序
     * <p>
     * 原理：把一个数插卡入到一个已经排好序的数组中，找到相应的位置插入
     * <p>
     * 可以把数组的第一个元素当作一个已经排好序的数组
     * <p>
     * 从第二个（i=1)开始，把要插入的元素提出来作为temp,依次和前面的元素（j)对比 如果比temp大，就往后移动一个
     * 最后把temp填到j位置
     * <p>
     * O（n²）是稳定的排序方法
     */
    public static void px(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的数向后移动一步 a[0-j]是已经排序的，越往左越小
                if (a[j] > temp) {
                    a[j + 1] = a[j];//记录j处就是temp要插入的位置，因为会做一次j--,所以循环外要j+1
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }

    /**
     * 希尔排序
     * <p>
     * 本质是插入排序，只不过是将待排序的序列按某种规则分成几个子序列，分别对几个子序列进行直接插入排序
     * <p>
     * 这个规则就是增量，增量选取很重要，增量一般选序列长度一半
     * 然后逐半递减，直到最后一个增量为1，为1相当于直接插入排序
     */
    public static void shellSort(int[] a) {
        int n = a.length;
        //进行分组，最开始时增量len为长度的一般
        for (int len = n / 2; len > 0; len /= 2) {
            //对各个分组进行插入排序
            for (int i = len; i < n; i++) {
                int inserted = a[i];
                int j;
                for (j = i - len; j >= 0 && inserted < a[j]; j -= len) {
                    a[j + len] = a[j];
                }
                a[j + len] = inserted;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 9, 5, 3};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}