**思路：**
1. 定义一个变量`maxLen`用来记录不重复字符串的最大长度；
2. 定义一个哈希表，辅助遍历查询
3. 用一对`左右指针`**遍历**字符串，**对每一个字符c作如下处理**：
- 判断该字符在不在`map`中，若存在 ==> 更新左边界`L = max{L , c_index + 1}`;
- 将该字符以及索引存放在`map`中；
- 更新`maxLen = max{maxLen , R-L+1}`;
4. 返回`maxLen`。



```java []
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //初始化
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        //遍历
        for(int L = 0, R = 0; R < s.length(); R ++){
            char c = s.charAt(R);
            if(map.containsKey(c)){
                L = Math.max(L, map.get(c) + 1);    //更新左边界L
            }
            map.put(c,R);       
            maxLen = Math.max(maxLen, R-L+1);   //更新最大长度记录
        }
        return maxLen;
    }
}
```
