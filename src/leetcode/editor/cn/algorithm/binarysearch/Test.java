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

    }

    public static int binarySearch(int[] arr, int key) {
        int min, mid, max;
        min = 0;
        max = arr.length - 1;
        mid = (min + max) >> 1;

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
}
