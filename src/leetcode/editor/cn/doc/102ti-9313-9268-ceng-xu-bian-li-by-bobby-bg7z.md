### 解题思路
![image.png](https://pic.leetcode-cn.com/1608860098-WxemMV-image.png)


### 代码

```java
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
        List<List<Integer>> bigList = new ArrayList<>();
        if(root == null) return bigList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> smallList = new ArrayList<>();
            int size = queue.size();
            while(size != 0) {
                TreeNode poll = queue.poll();
                smallList.add(poll.val);
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
            bigList.add(smallList);
        }
        return bigList;
    }
}
```