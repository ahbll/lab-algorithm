package top.bhappy.learn.sort.quick.v2;

import java.util.Arrays;

/**
 * @Author: liu lei
 * @Date: 2020/5/7 09:09
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 1, 4, 0, 9, 7, 5, 8, 2, 6};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        while (left < right) {
            while (left < right && arr[right] >= arr[left]) {
                right--;
            }
            swap(arr, left, right);
            while (left < right && arr[right] >= arr[left]) {
                left++;
            }
            swap(arr, left, right);
        }
        return left;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
