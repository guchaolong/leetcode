package leetcode.editor.cn;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 629 👎 0

import java.util.Arrays;

class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {7, 8, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        System.out.println(Arrays.toString(nums1));
        solution.merge(nums1, 2, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;
            int len = m + n - 1;

            while (len1 >= 0 && len2 >= 0) {
                nums1[len--] = nums1[len1] >= nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            while (len2 >= 0) {
                nums1[len--] = nums2[len2--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}