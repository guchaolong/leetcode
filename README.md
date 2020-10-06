# 位运算
1. 异或
    ```
    0^n = n
    a^b^c = a^c^b
    a^a = 0
    ```
    > 136



# 数学计算

```java
Math.max(i1,i2)
```



# 字符串

```java
char [] c = str.toCharArray() 转换为字符数组
str.equalsIgnoreCase(str2);
```



# 数组

```java
Arrays.sort(int [] arr) 排序
Arrays.equals(arr1, arr2) 数组比较
```



# HashMap
```java
map.containsKey(key)
```
>1、



# 链表

### 解题技巧
1. 快慢指针（有时3个指针）
prev curr next
```java
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
```



# 栈Stack

```java
    压栈：push(E)；
    弹出：pop(E)；
    取但不弹出：peek(E)
```
   > 155



# 队列Queue



```java
Queue<Integer> queue = new Queue<>();



//双端队列
LinkedList<Integer> queue = new LinkedList<>();
queue.pollLast()
queue.peekLast()
queue.addLast    
    

//优先队列，Min Heap  默认按从小到大 queue.peek()返回n个元素中的最小
Queue<Integer> queue = new PriorityQueue<>(n);
```



# 多线程
1. `Semphore` 可控制执行顺序 
    ```java
   acquire(n)获得n个许可（-n)，
   release(n)释放n个执行许可(+n)
   ```
    >1114、1117
