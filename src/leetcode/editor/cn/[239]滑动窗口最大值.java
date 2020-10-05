package leetcode.editor.cn;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 580 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            int len = nums.length;
//            if (nums.length * k == 0) {
//                return new int[0];
//            }
//            int[] result = new int[len - k + 1];
//            for (int i = 0; i < len - k + 1; i++) {
//                int max = Integer.MIN_VALUE;
//                for (int j = i; j < i + k; j++) {
//                    max = Math.max(max, nums[j]);
//                }
//                result[i] = max;
//            }
//            return result;
//        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k < 2) {
                return nums;
            }
            //用一个队列，记录当前位置开始，前k个数的最大值所在的位置
            LinkedList<Integer> queue = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            //遍历数组
            for (int i = 0; i < nums.length; i++) {
                // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                // 添加当前值对应的数组下标
                queue.addLast(i);
                // 判断当前队列中队首的值是否有效
                if (queue.peek() <= i - k) {
                    queue.poll();
                }
                // 当窗口长度为k时 保存当前窗口中最大值
                if (i + 1 >= k) {
                    result[i + 1 - k] = nums[queue.peek()];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}