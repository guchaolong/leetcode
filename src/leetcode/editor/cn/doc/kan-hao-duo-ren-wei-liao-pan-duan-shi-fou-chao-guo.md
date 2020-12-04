### 解题思路
由于使用long类型内存消耗有点多
但是代码相对容易理解把(至少我是这样认为的,哈哈哈)
代码里面有注释
![image.png](https://pic.leetcode-cn.com/1601016490-ioZzsV-image.png)
有优化提高执行用时的的方法,可以给我点思路(谢谢啦,哈哈哈)

### 代码

```java
class Solution {
    public int strToInt(String str) {
        //去除前后空格
        String trim = str.trim();

        //没有任何字符
        if (trim.equals("")) {
            return 0;
        }

        byte sign = 1; //符号 默认加号
        int i = 0; //下标

        //判断第一个是不是符号
        if (trim.charAt(0) == '-' || trim.charAt(0) == '+') {
            sign = (byte) (trim.charAt(0) == '-' ?  -1 :  1);
            i = 1;
        }

        long res = 0;
        
        for (; i < trim.length(); i++) {

            //不是数字
            //48对应的是0,57对应的是9
            if (trim.charAt(i) < 48 || trim.charAt(i) > 57) {
                break;
            }

            //叠加
            res = (res * 10) + (trim.charAt(i) - 48);

            //超过最大值或者最小值
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                //判断是什么符号 输出int的最大值或者最小值
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

        }

        return (int) (sign * res);
    }
}
```