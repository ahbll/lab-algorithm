package top.bhappy.learn.sort.select;

/**
 * @Author: liu lei
 * @Date: 2020/1/14 19:20
 * @Description:
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {9, 8, 6, 7, 1, 2, 4, 5, 0, 3};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            int value = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < value) {
                    index = j;
                    value = nums[j];
                }
            }
            if (i != index) {
                nums[index] = nums[i];
                nums[i] = value;
            }
        }
    }


}
