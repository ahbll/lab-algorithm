package top.bhappy.learn.search.binary.recur;

/**
 * @Author: liu lei
 * @Date: 2021/2/19 09:16
 * @Description:
 */

// 二分查找-递归
// 只适用数组
public class BinaryRecurSearch {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(arr1, 6));

        int[] arr2 = {2, 6, 8, 9, 11, 12, 16, 19, 20};
        System.out.println(search(arr2, 11));
    }

    public static int search(int[] arr, int num) {
        return search(arr, 0, arr.length - 1, num);
    }

    private static int search(int[] arr, int left, int right, int num) {
        if (left > right) {
            return -1;
        }
        // 防止溢出
        int mid = left + (right - left) / 2;
        if (arr[mid] == num) {
            return mid;
        } else if (arr[mid] > num) {
            return search(arr, left, mid - 1, num);
        } else {
            return search(arr, mid + 1, right, num);
        }
    }

}
