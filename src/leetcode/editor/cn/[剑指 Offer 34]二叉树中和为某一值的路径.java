package leetcode.editor.cn;

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 115 👎 0

import java.util.ArrayList;
import java.util.List;

class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        
    }
    
    
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        sum(root, new ArrayList<>(), result, sum);
        return result;

    }

    public void sum(TreeNode root, List<Integer> list, List<List<Integer>> result, int sum){
        if(root == null){
            return;
        }
        int target = sum - root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
        }else {
            sum(root.left, list, result, target);
            sum(root.right, list, result, target);
        }
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}