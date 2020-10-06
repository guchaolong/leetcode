package leetcode.editor.cn.algorithm.sort;

/**
 * Description:
 *
 * @author AA
 * @date 2020/10/6 13:59
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 7, 34, 5, 6, 9, 2, 3};
        int len = arr.length;
        buildMaxHeap(arr);
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }

        for (int i : arr) {
            System.out.print(i + ",");
        }


    }

    public static void buildMaxHeap(int[] arr) {
        int len = arr.length;
        //最后一个节点位置
        int last_index = len - 1;
        //最后一个非叶子节点位置
        int last_parent = (last_index - 1) / 2;
        for (int i = last_parent; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }


    //针对某个位置i，调整为大顶堆
    public static void heapify(int[] arr, int i, int len) {
        if (i >= len) {
            return;
        }

        int max = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < len && arr[left] > arr[max]) {
            max = left;
        }

        if (right < len && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            swap(arr, i, max);
            heapify(arr, max, len);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
