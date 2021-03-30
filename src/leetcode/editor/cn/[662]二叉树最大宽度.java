package leetcode.editor.cn;

//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 
// 👍 212 👎 0

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MaximumWidthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        
    }
    
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();//用于存放当前行不为空的节点的下标
        list.add(1);
        //二叉树节点下标  父i如果从1开始     则左2*i   右 2*i+1
        queue.add(root);
        while (!queue.isEmpty()){
            max = Math.max(max, list.getLast()-list.getFirst() + 1);
            int size = queue.size();
            while (size > 0){
                TreeNode cur = queue.poll();
                Integer curIndex = list.removeFirst();
                if(cur.left != null){
                    queue.add(cur.left);
                    list.add(curIndex * 2);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                    list.add(curIndex * 2 + 1);
                }
                size--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}