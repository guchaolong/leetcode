package leetcode.editor.cn.algorithm.other;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/12/4 1:55
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 5, 7}, 27));

    }


    //硬币面额 {2，5，7}   //需要凑出的金额 27
    public static int coinChange(int[] A, int M) {
        //0----n   [n-1]
        //0----n-1 [n]

        //凑0、1、2、3...27
        int[] f = new int[M + 1];
        int n = A.length;//硬币种类

        //初始条件
        f[0] = 0;

        //f[1],f[2],...f[27]
        for (int i = 1; i <= M; i++) {
            f[i] = Integer.MAX_VALUE;
            //最后一枚,是A中的某一枚
            for (int j = 0; j < n; j++) {
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
                }
            }
        }

        if (f[M] == Integer.MAX_VALUE) {
            f[M] = -1;
        }

        return f[M];
    }
}
