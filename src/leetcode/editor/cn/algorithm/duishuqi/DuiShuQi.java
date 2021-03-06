package leetcode.editor.cn.algorithm.duishuqi;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/12/5 15:42
 */
public class DuiShuQi {
    public static void main(String[] args) {
        int[] ints = generateRandomArray(20, 10);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }

    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
