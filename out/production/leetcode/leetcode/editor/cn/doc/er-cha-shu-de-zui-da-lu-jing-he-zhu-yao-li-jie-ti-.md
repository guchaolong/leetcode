### 解题思路：
参考 @Ikaruga， @cheney 的思路
首先解释题目意思：
* **路径**：从一个节点到另一个节点的路径。这个应该都是这么理解的
* **路径和**：**从一个起始节点出发** 的的所有路径的最大和
    > 1. 你可以选择树中的任意节点作为起始节点
    > 2. 但是起始节点只能选一个！即你最终选择的所有路径全部是从一个起始节点出发
   

* **限制条件**：路径上的点不能重复使用（下图（a）(b)）
    > 比如： 1-2-4-8 和 1-2-5-9 就只能选择其一，因为 1-2 重复利用了

![图片.png](https://pic.leetcode-cn.com/f7f14b5f671f7ede8333253a440d45bb3d81c1107de5ef9db88d74e14f7037b0-%E5%9B%BE%E7%89%87.png)


(a)、(b) 以 **节点1** 作为 起始节点 的其中 2 条路径。(c) 以 **节点2** 作为 起始节点 的所有路径;  (d) 以**节点3** 作为 起始节点 的路径

![图片.png](https://pic.leetcode-cn.com/0b34caf569ccbbaffdb1230e712db329412a7e040b3217504dd4ae2255771735-%E5%9B%BE%E7%89%87.png)



```Java []
 我们用题目的示例来描述一下这个算法过程：(理解如何递归很关键)
> 1. 从 dfs(-10) 开始， 

        1.1  dfs(9): 
            1.1.1 左孩子为空；贡献为 0
            1.1.2 右孩子为空，贡献为 0
            1.1.3 更新 res = max (-∞，(9 + 0 + 0)) = 9
            1.1.4 返回 dfs(9) = 9 + max(左孩子贡献，右孩子贡献)) = 9

        1.2  dfs(20)
            1.2.1 dfs(15):

                1.2.1.1 左孩子为空；贡献为0
                1.2.1.2 右孩子为空，贡献为0
                1.2.1.3 更新 res = max(9, 15 + 0 + 0) = 15
                1.2.1.4 返回 dfs(15) = 15 + 0 = 15

            1.2.2  dfs(7):

                1.2.2.1 左孩子为空；贡献为 0
                1.2.2.2 右孩子为空，贡献为 0
                1.2.2.3 更新 res = max(15, 7 + 0 + 0) = 15
                1.2.2.4 返回 dfs(7) = 7 + 0 = 7

            1.2.3  更新 res = max (15, 20 + dfs(15) + dfs(7) ) = 42
            1.2.4  返回dfs(20) = 20 + max(15, 7) = 35

        1.3 更新 res = max(42, -10 + dfs(9) + dfs(20) ) = max(42, 34) = 42 
        1.4 返回 dfs(-10) = -10 + max(9, 35) = 25 (当然这一步就没啥用了，已经有最终res)

所以最大路径和 res = 42 

关键就是区分：
1. 当前节点最大路径和计算：以当前节点为起点的所有路径和
2. 当前节点对上一层的贡献：只能选择当前节点的最大的一条路径作为贡献，因为路径节点不可重复

```
 




### 代码：

```Java []
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
    /**
    Q：左右孩子贡献为什么要大于等于0？
    A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
        而左右孩子贡献是「可选的」，也就是说当某一边贡献小于0的时候，我可以在计算路径和时不算这一边
        这种情况也就相当于其贡献为 0，但是注意路径和至少包含「当前节点的值」。
    **/
        int leftMax  = Math.max(0, dfs(root.left));         // 左孩子贡献
        int rightMax = Math.max(0, dfs(root.right));        // 右孩子贡献
        res = Math.max(res, root.val + leftMax + rightMax); // 更新res
        return root.val + Math.max(leftMax, rightMax);      // 返回当前节点的总贡献
    }

    
}
```