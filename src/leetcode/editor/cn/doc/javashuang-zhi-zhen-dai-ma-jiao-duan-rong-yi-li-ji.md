基本思路就是每一次区间`[l,r)`（左闭右开）中的数字相同，然后判断该区间的长度是否为1，若长度为1则通过尾插法插入到答案中（这一步看图）。
![62a6ee34555d112eb7e92ed9f66baba41aa0b9deec893ddfcc0ad07677d929ba-lc82.png](https://pic.leetcode-cn.com/6ed9f10ba17ab7836663b330b846e8cb4dd3b9a82c39bd3dd19844025da334e2-62a6ee34555d112eb7e92ed9f66baba41aa0b9deec893ddfcc0ad07677d929ba-lc82.png)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
                tail.next = l;  // 基本的尾插法                                         
                tail = l;                                               
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }
}
```