package leetcode.editor.cn;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1496 👎 0

class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));

    }

    /**
     * 异或运算法则
     * 　　1. a ^ b = b ^ a
     * 　　2. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c;
     * 　　3. d = a ^ b ^ c 可以推出 a = d ^ b ^ c.
     * 　　4. a ^ b ^ a = b
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}