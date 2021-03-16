package top.bhappy.testing.huawei.v2.m1;


/**
 * @Author: liu lei
 * @Date: 2021/3/3 18:00
 * @Description:
 */

/**
 * 数组{1, 8. 10, 2, 3...}，求非连续元素和的最大值
 */
public class Test1 {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 3, 7, 10};
        //f(n) = max(f(n-2) + arr[n], f(n - 1));
        int max = getMax(arr, arr.length - 1);
        System.out.println(max);
    }


    private static int getMax(int[] arr, int index) {
        if (index == 0) {
            return arr[0] ;
        } else if (index == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            return Math.max(getMax(arr, index - 2) + arr[index], getMax(arr, index - 1));
        }

    }

}
