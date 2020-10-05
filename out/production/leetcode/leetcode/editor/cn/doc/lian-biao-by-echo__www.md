### 解题思路
利用两个链表节点pre、now迭代实现链表的反转操作，其中利用临时节点tem保存now节点的下一个节点。
在循环里完成指针的反转，指针反转后，节点pre，now前进一个单位继续进行迭代。
### 代码

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
    public ListNode reverseList(ListNode head) {
       ListNode pre=null;//定义前一个节点
       ListNode now=head;//定义现在的节点
       while(now!=null)//循环条件：当前节点不为空
       {
           ListNode tem=now.next;//记录下当前节点的下一节点，防止指针反转后丢失后续节点
           now.next=pre;//当前节点的指针反转
           pre=now;//pre节点前进一个单位，接替now节点
           now=tem;//now节点前进一个节点，接替tem节点
       } 
       return pre;//循环终止时now节点为null，此时前一个节点pre就是反转后链表的第一个节点 
    }
}
```