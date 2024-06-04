package top.bhappy.testing.huawei.v2.m2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liu lei
 * @Date: 2021/3/16 16:20
 * @Description:
 */

/**
 * 整型数组nums，整数target
 * 求nums中和为target的两个数下标
 * 解法复杂度为o（n）
 */

public class Test1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = find1(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println("-----");
        res = find2(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    private static int[] find1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static int[] find2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(nums[i]);
            if (j != null) {
                return new int[]{i, j};
            }
        }
        return null;
    }


}
