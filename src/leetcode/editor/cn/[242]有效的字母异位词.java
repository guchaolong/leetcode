package leetcode.editor.cn;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 256 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            //转数组-> 排序 -> 比较
//            char[] chars_s = s.toCharArray();
//            char[] chars_t = t.toCharArray();
//            Arrays.sort(chars_s);
//            Arrays.sort(chars_s);
//            return Arrays.equals(chars_s, chars_t);


            //数组记录各字母出现次数
//            if (s == null || t == null || s.length() != t.length()) {
//                return false;
//            }
//            int[] num = new int[26];
//            for (int i = 0; i < s.length(); i++) {
//                num[s.charAt(i) - 'a']++;
//                num[t.charAt(i) - 'a']--;
//            }
//            for (int i = 0; i < num.length; i++) {
//                if (i != 0) {
//                    return false;
//                }
//            }
//            return true;


            //hashMap
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }

            for (char c : t.toCharArray()) {
                if (!map.containsKey(c)) {
                    return false;
                } else {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
                }
            }

            if (!map.isEmpty()) {
                return false;
            } else {
                return true;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}