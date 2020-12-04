package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 850 👎 0

import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        
    }
    
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        String res = "";

        if(s == null || s == "" || t == null || t == "" || s.length() < t.length()){
            return res;
        }

        int minLen = Integer.MAX_VALUE;//最小长度
        int[] need = new int[128];//记录，覆盖t 所需要的所有字符，及其对应的个数
        int[] window = new int[128];//滑动窗口，记录当前窗口内，每个字符出现的次数，right指针右移 出现次数+1， left指针右移，出现次数-1
        int miss = t.length(); //当前窗口内缺失的字符数，当miss=0时，当前窗口就满足要求，

        //t需要的字符，对应的次数添加到need
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        //定义左右指针，滑动窗口左右边界
        int left = 0, right = 0;
        while (right < s.length()){//先扩展窗口，右指针往右移动
            char c = s.charAt(right);
            window[c]++;//出现一次就+1
            if(need[c] > 0 && need[c] >= window[c]){//该字符是否是t中的字符，并且数量还不够
                miss--;
            }

            //当前窗口满足要求，但是因为是移动右指针，左边可能出现一些多余的或者不属于t的字符，所以还需要左边收缩窗口
            while (miss == 0){
                char cL = s.charAt(left);
                window[cL]--;
                if(need[cL] > 0 && need[cL] > window[cL]){
                    miss++;
                }
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left++;
            }
            right++;//扩展窗口
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}