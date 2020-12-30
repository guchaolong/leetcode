### 解题思路
本题解 依旧采用了 **`题解区大佬`** 的思想：
> 为了满足 “进阶要求”，使用 “归并排序”

### 运行结果
![image.png](https://pic.leetcode-cn.com/1605924601-aGNUQq-image.png)

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
            查找 当前链表的 “中点”
         */
        ListNode fastNode = head;
        ListNode slowHead = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowHead = slowHead.next;
            fastNode = fastNode.next.next;
        }

        ListNode midNode = slowHead.next;
        slowHead.next = null;   // 将 两半链表 断开
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(midNode);
        return merge(leftHead, rightHead);
    }

    /**
     * 为 两个链表 进行 “归并排序”
     * @param leftHead 左链表头
     * @param rightHead 右链表头
     * @return 当前两个链表的 排序后的头
     */
    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        if (leftHead.val < rightHead.val) {
            leftHead.next = merge(leftHead.next, rightHead);
            return leftHead;
        } else {
            rightHead.next = merge(leftHead, rightHead.next);
            return rightHead;
        }
    }
}
```
打卡122天，加油！
昨天中雨，早上刚停，下午竟然要测50和1000😨