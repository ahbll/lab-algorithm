package top.bhappy.learn.sort.quick.v1;

import java.util.Arrays;

/**
 * @Author: liu lei
 * @Date: 2020/2/27 10:16
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{6, 3, 1, 4, 0, 9, 7, 5, 8, 2, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);

    }

    public static int partition(int[] array, int left, int right) {
        int pivotKey = array[left];
        while (left < right) {
            while (pivotKey <= array[right] && left < right) {
                right--;
            }
            swap(array, left, right);
            while (pivotKey >= array[left] && left < right) {
                left++;
            }
            swap(array, left, right);
        }
        return left;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
