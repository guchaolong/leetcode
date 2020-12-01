### 解题思路
此处撰写解题思路
![image.png](https://pic.leetcode-cn.com/1605676365-BVppNc-image.png)

### 代码

```java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        res[T.length-1]=0;
        int left,rigth;
        for(left=T.length-2;left>=0;left--){
            rigth=left+1;
            while(rigth<T.length){
                if(T[rigth]>T[left]){
                    res[left]=rigth-left;
                    break;
                }else if(res[rigth]==0){
                    res[left]=0;
                    break;
                }
                rigth+=res[rigth];
            }
        }
        return res;
    }
}
```