package top.bhappy.learn.search.binary.recur;

/**
 * @Author: liu lei
 * @Date: 2024/4/24 19:58
 * @Description:
 */
public class BinaryRecurSearch2 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(arr1, 6));

        int[] arr2 = {2, 6, 8, 9, 11, 12, 16, 19, 20};
        System.out.println(search(arr2, 11));
    }

    public static int search(int[] arr, int num) {
        return search(arr, num, 0, arr.length - 1);
    }

    public static int search(int[] arr, int num, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] < num) {
            return search(arr, num, mid + 1, right);
        } else if (arr[mid] > num) {
            return search(arr, num, left, mid - 1);
        } else {
            return mid;
        }
    }
}
