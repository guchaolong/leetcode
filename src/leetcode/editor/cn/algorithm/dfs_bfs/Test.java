/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/8/11 1.0          guchaolong          Creation File
 */
package leetcode.editor.cn.algorithm.dfs_bfs;

import java.util.*;

/**
 * 深度优先 DFS
 * 广度优先 BFS
 */
public class Test {

    /**
     * DFS递归实现
     */
    public static void DFSWithRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());

        if (root.left != null) {
            DFSWithRecursion(root.left);
        }
        if (root.right != null) {
            DFSWithRecursion(root.right);
        }
    }

    /**
     * DFS的迭代实现版本（Stack）
     */
    public static void DFSWithStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.value);
            //在这里处理遍历到的TreeNode
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }


    /**
     * 广度优先
     * 一层一层的遍历，使用队列解决
     * <p>
     * 首先把根节点放到队列
     * 然后使用queue.poll()从队列顶端依次取出，不为空的左右节点都往队列尾部加
     *
     * @param root
     */
    public static void BFSWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.println("current node:" + currentNode.value);
            if (currentNode.left != null) {
                ((LinkedList<TreeNode>) queue).add(currentNode.left);
            }
            if (currentNode.right != null) {
                ((LinkedList<TreeNode>) queue).add(currentNode.right);
            }
        }

    }


    /**
     * 使用Queue实现BFS
     * 图和树的最大区别在于图的下一个节点可能指向已访问过的节点。
     * 因此在使用BFS及DFS遍历时，应维护一个Set，Set中存放已被访问过的节点，在遍历时先判断节点未被访问过再遍历即可
     *
     * @param root
     */
    public static void BFSWithQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node);
            //在这里处理遍历到的Node节点
            if (node.children != null) {
                for (Node child : node.children) {
                    if (child != null && !visited.contains(child)) {
                        queue.add(child);
                    }
                }
            }
        }
    }


    //


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);

        System.out.println("=======================递归实现==========================");
        DFSWithRecursion(n1);
        System.out.println("========================栈实现=========================");
        DFSWithStack(n1);
        System.out.println("========================队列实现=========================");
        BFSWithQueue(n1);


    }
}