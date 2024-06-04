package top.bhappy.leetcode.num4;

/**
 * @Author: liu lei
 * @Date: 2022/3/7 14:32
 * @Description:
 */
public class Main1 {

    public static void main(String[] args) throws Exception {
        int[] nums1 = {1, 3, 10};
        int[] nums2 = {5, 6};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }

    // 1 4 | 5 7 8
    // 2 3 | 6

    // 1 4 5 | 7 8
    // 2 3 | 5 6

    // 思路：
    // 根据时间复杂度要求，应采用二分查找法
    // 从数学角度分析，中位数在哪？分别在两个数组中划一道分割线，此分割线两边元素个数相等，则中位数取决于分割线两侧的四个元素
    // 问题转化为求分割线的位置
    // 分割线应满足条件
    // 1、均分两个数组 或 左侧比右侧多一个
    // 2、left1 < right2 && right1 < left2
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 特殊情况处理
        // 通过将短的数组放在上面，规避第二个数组下标越界的情况
        int[] nums;
        if (nums1.length > nums2.length) {
            nums = nums1;
            nums1 = nums2;
            nums2 = nums;
        }


        int len1 = nums1.length;
        int len2 = nums2.length;
        // 元素总个数
        int len = len1 + len2;
        // 左侧元素个数（向上取整）
        int leftLen= (len + 1) / 2;
        // 数组1的分割线左侧下限
        int left1 = 0;
        // 数组1的分割线右侧上限
        int right1 = len1;
        // 数组1的分割线位置
        int mid1;
        // 数组2的分割线位置
        int mid2;
        while (left1 < right1) {
            mid1 = (left1 + right1 + 1) / 2;
            mid2 = leftLen - mid1;
            // 只需要判断这一个条件？？？
            if (nums1[mid1 - 1] > nums2[mid2]) {
                right1 = mid1 - 1;
            } else {
                left1 = mid1;
            }
        }
        mid1 = left1;
        mid2 = leftLen - left1;
        int leftMax1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
        int rightMin1 = mid1 == len1 ? Integer.MAX_VALUE : nums1[mid1];
        int leftMax2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
        int rightMin2 = mid2 == len2 ? Integer.MAX_VALUE : nums2[mid2];
        if (len % 2 != 0) {
            return Math.max(leftMax1, leftMax2);
        } else {
            return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
        }
    }
}
