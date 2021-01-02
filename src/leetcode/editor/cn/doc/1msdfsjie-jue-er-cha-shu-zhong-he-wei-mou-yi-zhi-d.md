一.解题思路：
1. 定义一个res集合用来存储结果，再定义一个集合temp用来存储当前路径上已经访问过的节点
2. dfs深度优先搜索对res进行赋值
3. dfs的递归终结条件，当前节点为null
4. 每次递归，先求出下一个sum值赋值给nextSum
5. 让后将当前值存入temp链表
6. 判断当前是否为叶子节点，如果是叶子节点，判断nextSum是否为0，如果等于0，则符号条件，将当前路径添加到res集合
7. 如果不是叶子节点，则对当前节点的左右节点进行分治递归
8. 当前层递归最后将当前节点从temp集合移除
9. 搜索结束，res即为最终结果

二.时间复杂度：o(N)
三.空间复杂度：o(N)
四.执行用时: 1 ms,超过来100%的java提交记录
五.内存消耗: 38.4 MB,超过了98.5%的java提交记录
六.java代码：
```
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    public void dfs(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        int nextSum = sum - root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (nextSum == 0) {
                res.add(new ArrayList<>(temp));
            } 
        } else {
            dfs(root.left, nextSum, temp, res);
            dfs(root.right, nextSum, temp, res);
        }
        temp.remove(temp.size() - 1);
    }
}
```