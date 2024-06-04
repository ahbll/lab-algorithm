package top.bhappy.leetcode.num4;

/**
 * @Author: liu lei
 * @Date: 2024/4/25 20:04
 * @Description:
 */
public class Main2 {

    public static void main(String[] args) throws Exception {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 将大数组放在上面
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        // 数组1的长度
        int len1 = nums1.length;
        // 数组2的长度
        int len2 = nums2.length;
        // 有一个数组为空，特殊处理
        if (len2 == 0) {
            return len1 % 2 == 0 ? (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2.0 : nums1[len1 / 2];
        }
        int count = len1 + len2;
        // 两个数组左边元素总个数
        int lCount = count / 2;
        // 元素总个数是否为偶数
        boolean flag = count % 2 == 0;
        // 第一个数组二分查找左边界(左侧元素个数)
        int left = 0;
        // 第一个数组二分查找右边界(左侧元素个数)
        int right = len1;
        while (left < right) {
            // 第一个数组左边元素个数
            int lCount1 = (left + right) / 2;
            // 第二个数组左边元素个数
            int lCount2 = lCount - lCount1;
            int lNum1 = lCount1 == 0 ? Integer.MIN_VALUE : nums1[lCount1 - 1];
            int rNum1 = lCount1 == len1 ? Integer.MAX_VALUE : nums1[lCount1];
            int lNum2 = lCount2 == 0 ? Integer.MIN_VALUE : nums2[lCount2 - 1];
            int rNum2 = lCount2 == len2 ? Integer.MAX_VALUE : nums2[lCount2];
            if (lNum1 > rNum2) {
                // 向左查找
                right = (left + right) / 2 - 1;
            } else if (lNum2 > rNum1) {
                // 向右查找
                left = (left + right) / 2 + 1;
            } else {
                break;
            }
        }
        int lCount1 = (left + right) / 2;
        int lCount2 = lCount - lCount1;
        int lNum1 = lCount1 == 0 ? Integer.MIN_VALUE : nums1[lCount1 - 1];
        int rNum1 = lCount1 == len1 ? Integer.MAX_VALUE : nums1[lCount1];
        int lNum2 = lCount2 == 0 ? Integer.MIN_VALUE : nums2[lCount2 - 1];
        int rNum2 = lCount2 == len2 ? Integer.MAX_VALUE : nums2[lCount2];
        if (flag) {
            return (Math.max(lNum1, lNum2) + Math.min(rNum1, rNum2)) / 2.0;
        } else {
            return Math.min(rNum1, rNum2);
        }
    }

}
