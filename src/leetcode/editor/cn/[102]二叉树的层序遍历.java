package leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 740 👎 0

import java.nio.file.Path;
import java.util.*;

class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root, 1);

        int currLevel = 1;
        List<Integer> currList = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int currNodeLevel = levelMap.get(curr);
            if(currNodeLevel != currLevel){
                res.add(currList);
                currList = new ArrayList<>();
                currLevel++;
            }
            currList.add(curr.val);
            if(curr.left != null){
                levelMap.put(curr.left, currNodeLevel + 1);
                queue.add(curr.left);
            }
            if(curr.right != null){
                levelMap.put(curr.right, currNodeLevel + 1);
                queue.add(curr.right);
            }
        }
        res.add(currList);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}