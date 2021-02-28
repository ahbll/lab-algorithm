package top.bhappy.learn.sort.insert;

/**
 * @Author: liu lei
 * @Date: 2020/1/14 19:21
 * @Description:
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {9,8,6,7,1,2,4,5,0,3};
        //i = 4
        //value = 1
        //{0,5,6,7,1,2}
        //{0,5,6,7,7,2}
        //{0,1,5,6,7,2}

        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] nums) {
        int value;
        int index;
        for (int i = 1; i < nums.length; i++) {
            value = nums[i];
            index = i;
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > value) {
                    nums[j] = nums[j - 1];
                    index = j - 1;
                } else {
                    break;
                }
            }
            nums[index] = value;
        }
    }
}
