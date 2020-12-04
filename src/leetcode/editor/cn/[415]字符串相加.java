package leetcode.editor.cn;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都
// num1 和num2 都不包含任何前导零 只包含数字 0-9
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 273 👎 0

class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        String s = solution.addStrings("143224342312312", "94365363645756756345534123");
//        94365363645756756345534123
           //        143224342312312
//        94365363645899980687846435
        System.out.println(s);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int carry = 0;
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            StringBuilder result = new StringBuilder();
            while (i >= 0 || j >= 0 || carry != 0) {
                int x = i < 0 ? 0 : num1.charAt(i--) - '0';
                int y = j < 0 ? 0 : num2.charAt(j--) - '0';
                int sum = x + y + carry;
                carry = sum / 10;
                result.append(sum % 10);
            }
            return new String(result.reverse());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}