package leetcode.editor.cn.algorithm.binarysearch;

/**
 * Description:二分查找
 *
 * @author AA
 * @date 2020/8/19 14:32
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 9, 14};
        System.out.print(binarySearch(arr, 6));

        int[] arr2 = {1, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 9, 14};
        System.out.print(nearestIndex(arr2, 4));

    }

    public static int binarySearch(int[] arr, int key) {
        int min, mid, max;
        min = 0;
        max = arr.length - 1;
        mid = min + (max - min) >> 1;

//        int L, R;
//        int mid = (L + R) / 2        //如果L R都非常非常大，可能出现溢出
//        int mid = L + (R -L) / 2     //防止溢出
//        int mid = L + (R -L) >> 2    //位运算更快

        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid + 1;
            }
            if (key < arr[mid]) {
                max = mid - 1;
            }
            if (max < min) {
                return -1;
            }
            mid = (min + max) >> 1;
        }

        return mid;
    }

    //有序arr中， 满足arr[index] >= value 的最左侧位置
    public static int nearestIndex(int[] arr, int value) {

        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
