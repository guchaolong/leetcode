### 解题思路
最开始的思路是使用一个变量来记录当前栈中的最小值，每次push元素和pop元素时都对该记录进行更新。这种方式虽然能够通过也满足题意，但是push操作和pop操作的效率就会比较低。

看了一下题解，感觉使用辅助最小栈的方式还是很nb的。

整体的结构为两个同时增长的栈，一个普通的栈`stack`，一个顶端记录最小值的栈`minStack`。**个人理解`minStack`其实是一种dp的思想**，假设`last`为`minStack`的最后一个下标，那么`minStack[last]`（`dp[last]`）记录的就是`last`下标之前`stack`中的最小值。故每添加一个元素就有：
```
last++
dp[last] = min(dp[last-1], newElement)

即 minStack.push( min(minStack.top(), newElement) )
```

利用空间换时间，所有操作的时间复杂度都是*O(1)*。

### Java集合的使用注意
Java的集合包中本身就有栈的实现`Stack`，如果看过API或者是源码就会知道Java中的`Stack`是线程安全的，所有对外暴露的操作都使用了`synchronized`关键字，即加了一个重锁。什么是重锁？重锁就是需要由用户态切换到核心态，由操作系统来进行线程的同步互斥管理。

所以一般在单线程情况下，没有必要使用`Stack`，可以使用`Deque`来替代。`Deque`中也实现了符合栈特性的`push(E e)`和`pop()`操作，但还有一点要注意的是，`Deque`实现的栈的**栈顶是其首元素**，即读取栈顶的元素应该使用`peekFirst()`。

接着再总结一下，集合类中大致的操作规律：

| 操作   | 成功               | 失败     |
| ------ | ------------------ | -------- |
| remove | 删除，并获取元素   | 抛出异常 |
| poll   | 删除，并获取元素   | 返回null |
| get    | 获取元素           | 抛出异常 |
| peek   | 获取元素           | 返回null |
| add    | 添加元素，返回true | 返回fals |




### 代码

```java
class MinStack {
    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {

    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else 
            minStack.push(Math.min(x, minStack.peekFirst()));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}
```

#### 对你有帮助就来一个棒棒吧！欢迎评论:)