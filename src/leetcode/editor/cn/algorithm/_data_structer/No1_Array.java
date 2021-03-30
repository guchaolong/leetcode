package leetcode.editor.cn.algorithm._data_structer;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/24 3:50
 */
public class No1_Array {
    public static void main(String[] args) {

        /**
         * 1、创建数组，多维数组第一个方括号内必须有数值
         */
        int len = 10;
        int [] nums = new int[len];
        int[] num = new int[]{3, 4};
        int[] nums1 = {1, 2, 3};
        int [][] nums2 = new int[len][];
        int [][][] nums3 = new int[len][][];

        int[][] nums4 = {{1, 2, 3}, {7, 4}, {9, 5, 6}};
        System.out.println(nums4.length);//3
        System.out.println(nums4[0][2]);//3

        /**
         * 2、一维数组：数组复制
         * 对于一维数组来说可以直接通过clone()或arraycopy()方法来进行复制；
         * 但对于多维数组，由于以上两个方法是浅复制，因此需要降至低维进行复制
         */
        int[] n1 = {1, 2, 3, 4};
        int[] n2 = new int[4];

        //方法一
        for (int i = 0; i < n1.length; i++) {
            n2[i] = n1[i];
        }

        //方法二
        n2 = n1.clone();

        //方法三
        System.arraycopy(n1, 0, n2, 0, n1.length);

        for (int i = 0; i < n2.length; i++) {
            System.out.println(n2[i]);
        }

        /**
         * 多维数组复制
         */
        int [][] nn1 = {{1, 3, 4}, {2, 4}};
        int [][] nn2 = new int[2][];
        for (int i = 0; i < nn1.length; i++) {
            nn2[i] = nn1[i].clone();
            //System.arraycopy(matrix[i],0,copy[i],0,n);//使用arraycopy实现
        }
    }
}
