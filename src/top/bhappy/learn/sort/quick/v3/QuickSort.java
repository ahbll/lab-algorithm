package top.bhappy.learn.sort.quick.v3;


/**
 * @Author: liu lei
 * @Date: 2021/2/16 01:05
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        long[] array = {3, 6, 7, 1, 6, 2, 9, 5, 4, 8};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print("  ");
        }
    }

    public static void sort(long[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(long[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

    private static int partition(long[] array, int left, int right) {
        while (left < right) {
            while (array[left] <= array[right] && left < right) {
                right --;
            }
            swap(array, left, right);
            while (array[left] <= array[right] && left < right) {
                left++;
            }
            swap(array, left, right);
        }
        return left;
    }

    private static void swap(long[] array, int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
