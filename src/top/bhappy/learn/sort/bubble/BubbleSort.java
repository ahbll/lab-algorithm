package top.bhappy.learn.sort.bubble;

/**
 * @Author: liu lei
 * @Date: 2020/1/14 19:19
 * @Description:
 */
public class BubbleSort {

    public static void main(String[] args) {
        //int[] array = {9,8,6,7,1,2,4,5,0,3};
        int[] array = {3, 2, 1, 4, 5, 7, 8, 11, 9, 10, 6};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                count++;
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        System.out.println(count + "---------------");
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
