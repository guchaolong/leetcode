package leetcode.editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 916 👎 0

class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        
    }
    
    
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        //寻找中点
        while (p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //反转后半部分
        p2 = p1.next;
        p1.next = null;
        ListNode p3 = null;
        while (p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        //反转完成后p1指向最后一个节点， p2, P3指向null
        p3 = p1;//用p3保存
        p2 = head;

        boolean res = true;
        while (p1 != null && p2 != null){
            if(p1.val != p2.val){
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        p2 = null;
        while (p3 != null){
            p1 = p3.next;
            p3.next = p2;
            p2 = p3;
            p3 = p1;
        }

        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}