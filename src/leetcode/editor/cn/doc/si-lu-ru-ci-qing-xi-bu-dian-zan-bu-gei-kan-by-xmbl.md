题目要求写一个`MinStack`的数据结构，实现`push`,`pop`,`top`,`getMin`等方法；

![微信图片_20200920180232.jpg](https://pic.leetcode-cn.com/1600596169-MvHMqx-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200920180232.jpg)

**思路分析：**
1. 成员变量：定义两个队列`stackA`和`stackB`
2. 构造方法：给两个队列创建对象
3. `push`: 添加元素`e`的时候，`stackA`正常添加，`stackB`需要比较一下，如果`e`**小于等于**栈顶元素的话，就添加，否则，过！！
4. `pop`: 弹出的时候`stackA`正常弹出栈顶元素`e`，如果`stackB`的栈顶元素和`e`相同，那么`stackB`也要弹出栈顶元素；
5. `top`: 直接读取`stackA`的栈顶元素；
6. `getMin`: 直接读取`stackB`的栈顶元素；

```java []
class MinStack {
    //成员变量
    private LinkedList<Integer> stackA;
    private LinkedList<Integer> stackB;
    //构造方法
    public MinStack() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }   
    //成员方法
    public void push(int x) {
        stackA.push(x);
        if(stackB.isEmpty() || x <= stackB.peek()){
            stackB.push(x);
        }
    }    
    public void pop() {
        int e = stackA.pop();
        if(!stackB.isEmpty() && e == stackB.peek()){
            stackB.pop();
        }
    }   
    public int top() {
        return stackA.peek();
    }
    public int getMin() {
        return stackB.peek();
    }
}
```
![微信图片_20200920111109.jpg](https://pic.leetcode-cn.com/1600598576-EeBKtW-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200920111109.jpg)


