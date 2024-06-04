package top.bhappy.learn.search.binary.loop;

/**
 * @Author: liu lei
 * @Date: 2021/2/19 09:16
 * @Description:
 */

// 二分查找-循环
public class BinaryLoopSearch {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(arr1, 6));

        int[] arr2 = {0, 2, 6, 8, 9, 11, 12, 16, 19, 20};
        System.out.println(search(arr2, 12));
    }

    public static int search(int[] arr, int num) {
        return search(arr, 0, arr.length - 1, num);
    }

    private static int search(int[] arr, int left, int right, int num) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
