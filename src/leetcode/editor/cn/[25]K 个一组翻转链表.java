package leetcode.editor.cn;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 804 👎 0

import java.lang.ref.PhantomReference;


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //边界情况
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        //虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //前继节点
        ListNode prev = dummy;
        while (prev != null) {
            //组内开始节点和结束节点
            ListNode start = prev.next;
            ListNode end = prev.next;

            //定位本组的结束节点
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            //不足k个
            if (end == null) {
                break;
            }

            ListNode next = end.next;//缓存本组的后继节点(下一组的开始节点）
            end.next = null;//切断后边的分组

            prev.next = reverse(start);//翻转当前组

            //翻转完成，需要把指针移动到下组需要的位置
            start.next = next;
            prev = start;
        }
        return dummy.next;
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(-1);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
