package top.bhappy.learn.numberk;

/**
 * @Author: liu lei
 * @Date: 2020/2/25 15:29
 * @Description:
 */

/**
 * divide & conquer
 */
public class D_C {

    public static int findNumberK(int[] array, int k) {
        //k - 1第k大的数，坐标为k - 1
        return findK(array, 0, array.length - 1, k - 1);

    }

    public static int findK(int[] array, int left, int right, int k) {
        if (left < right) {
            int pivot = partition(array, left, right, k);
            if (k == pivot) {
                return array[k];
            } else if (k < pivot) {
                return findK(array, left, pivot - 1, k);
            } else {
                return findK(array, pivot + 1, right, k);
            }
        }
        //k在left和right之间
        return array[left];
    }


    public static int partition(int[] array, int left, int right, int k) {
        int pivotKey = array[left];
        while (left < right) {
            while (left < right && pivotKey >= array[right]) {
                right--;
            }
            swap(array, left, right);
            while (left < right && pivotKey <= array[left]) {
                left++;
            }
            swap(array, left, right);
        }
        return left;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
