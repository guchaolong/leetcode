package leetcode.editor.cn;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 525 👎 0

class MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.printf("", solution.multiply("9", "99"));
        
    }
    
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        // write code here
        String res = "0";
        int j = num2.length() - 1;
        while(j >= 0){
            int x = num2.charAt(j) - '0';
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < num2.length() -1 - j; k++){
                sb.append("0");
            }
            int carry = 0;
            int i = num1.length() - 1;
            while(i >= 0 || carry != 0){
                int y = i >= 0 ? num1.charAt(i--) - '0' : 0;
                int z = x * y + carry;
                sb.append(z % 10);
                carry = z / 10;
            }
            res = addString(res, sb.reverse().toString());
            j--;
        }
        return res;
    }


        public String addString(String s, String t){
            int i = s.length() - 1, j = t.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while(i >= 0 || j >= 0 || carry != 0){
                int x = i >= 0 ? s.charAt(i--) - '0' : 0;
                int y = j >= 0 ? t.charAt(j--) - '0' : 0;
                int sum = x + y + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            }
            return new String(sb.reverse());
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}