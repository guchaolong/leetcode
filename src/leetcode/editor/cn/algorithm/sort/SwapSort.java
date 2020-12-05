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

/**
 * Description: 交换排序 包括冒泡和快速排序
 *
 * @author guchaolong
 * @date 2019/6/1 20:47
 */
public class SwapSort {
    /**
     * 冒泡排序
     * <p>
     * 第1个  分别和第2、3、4...n个比较，把最小的放到第1个位置
     * 第2个  分别和第3、4、5...n个比较....
     * ...
     * 第n-1个 和第n个比较...小的放前面
     * <p>
     * 时间复杂度 O(N²)
     * 时间复杂度 O(1)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * 选一个基准数temp，先从右边往左找(j)，找到一个比temp小的，然后停下
     * i再从左往右找(i)，找到一个比temp大的然后停下，如果位置i<j,就交换
     * 最终i和j会再某个位置相遇，把temp和该位置交换，那么temp就找到了他正确的位置，左边的都比temp小，右边的都比temp大
     * <p>
     * 再分别对temp两边的数组递归调用
     * <p>
     * 最差时间复杂度和冒泡排序是一样的都是O(N²)，它的平均时间复杂度为O(NlogN)
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位  10,7,2,4,7,62,3,4,2,1,8,9,19
        temp = arr[low];
        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, i - 1);
        //递归调用右半数组
        quickSort(arr, i + 1, high);
    }

    public static void main(String[] args) {
        quickSort(new int[]{4, 5, 1, 6, 2, 8, 7}, 0, 6);
    }
}