package leetcode.editor.cn;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2964 👎 0

class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        
    }
    
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    //暴力解法
//    public String longestPalindrome(String s) {
//        if(s == null || s.length() < 2){
//            return s;
//        }
//
//        int maxLen = 1;
//        int begin = 0;
//
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++){
//                if(j - i + 1 > maxLen && validPalindromic(arr, i, j)){
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//
//    public boolean validPalindromic(char[] arr, int i, int j){
//        while (i < j){
//            if(arr[i] != arr[j]){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }

    public String longestPalindrome(String s) {

        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        int start = 0;

        //第一步：状态容器；dp[i][j]表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;//单个字符是回文串
        }

        char[] arr = s.toCharArray();
        //按顺序填充
        for(int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if(arr[i] != arr[j]){
                    dp[i][j] = false;
                }else {//i j位置字符一样
                    if(j - i <= 2){//aa、a？a这两种情况之间返回true
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];//状态转移方程
                    }
                }

                //只要dp[i][j] = true成立，就表示s[i...j]是回文串，比较并替换长度和开始位置
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}