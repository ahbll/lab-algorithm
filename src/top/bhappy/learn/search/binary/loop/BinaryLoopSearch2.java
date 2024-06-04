package top.bhappy.learn.search.binary.loop;

/**
 * @Author: liu lei
 * @Date: 2021/2/19 14:59
 * @Description:
 */
// 二分查找-循环-查找第一个出现的元素
public class BinaryLoopSearch2 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 11, 12};
        System.out.println(search(arr1, 6));

        int[] arr2 = {0, 2, 6, 8, 8, 8, 9, 11, 12, 16, 19, 20};
        System.out.println(search(arr2, 8));
        System.out.println(search(arr2, 20));
        System.out.println(search(arr2, 100));
    }

    public static int search(int[] arr, int num) {
        return search(arr, 0, arr.length - 1, num);
    }

    private static int search(int[] arr, int left, int right, int num) {
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 最后一次 left = mid + 1 可能会导致left越界
        if (left < arr.length && num == arr[left]) {
            return left;
        }
        return -1;
    }


}

