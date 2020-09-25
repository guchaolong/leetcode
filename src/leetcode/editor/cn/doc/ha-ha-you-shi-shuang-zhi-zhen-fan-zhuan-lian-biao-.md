# 方法一：迭代法
两个指针一前一后，反转三步走，直到后指针遍历完链表：保存后方，反指前方，前进
1. 特判：过滤掉空链表或者单节点链表
2. 初始化：定义一前一后两个指针`pre = null`和`cur = head`,
2. 遍历，三步走：
    - **保存后方**: `tmp = cur.next`;
    - **反指前方**：`cur.next = pre`;
    - **前进**： `pre = cur; cur = tmp`;
3. 最后`pre`落在了原来链表的最后一个节点上，所以要返回`pre`;
```java []
class Solution {
    public ListNode reverseList(ListNode head) {
        //1.特判
        if(head == null || head.next == null){
            return head;
        }
        //初始化
        ListNode pre = null;
        ListNode cur = head;
        //遍历
        ListNode tmp;
        while(cur != null){
            tmp = cur.next;    //保存后方
            cur.next = pre;    //反指前方
            pre = cur;      //前行
            cur = tmp;
        }
        return pre;
    }
}
```
# 方法二：递归法

递归思想就是把head后面的链表看做一个整体，然后调用本方法把它进行反转，结果为p。
接下来就是处理head指向的问题了，实在没啥好讲的，看图吧。

![微信截图_20200921145608.png](https://pic.leetcode-cn.com/1600671579-KCTIMZ-%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20200921145608.png)

```java []
class Solution {
    public ListNode reverseList(ListNode head) {
        //特判
        if(head == null || head.next == null) return head;      
        ListNode p = reverseList(head.next); //递归
        head.next.next = head; //反转两个方向
        head.next = null;
        return p;
    }
}
```

