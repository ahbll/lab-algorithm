package top.bhappy.learn.heap;

/**
 * @Author: liu lei
 * @Date: 2021/2/26 09:55
 * @Description:
 */

import java.util.Arrays;

/**
 *           9
 *       7       6
 *     5   4   3   1
 *   0
 *
 *           0
 *       1        2
 *     3   4    5   6
 */
public class MaxHeap {

    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array, array.length);
        System.out.println(Arrays.toString(array));

        int[] array2 = new int[]{10, 9, 8, 7, 5, 2, 3, 1, 6, 100};
        upAdjust(array2, array2.length);
        System.out.println(Arrays.toString(array2));


        MaxHeap mHeap = new MaxHeap(10);
        mHeap.push(3);
        mHeap.push(7);
        mHeap.push(1);
        mHeap.push(2);
        mHeap.push(9);
        System.out.println(mHeap.pop());
        System.out.println(mHeap.pop());
        System.out.println(mHeap.pop());
        System.out.println(mHeap.pop());
        System.out.println(mHeap.pop());


        int[] array3 = new int[]{10, 9, 8, 7, 5, 2, 3, 1, 3, 6, 100};
        sort(array3);
        System.out.println(Arrays.toString(array3));

    }


    private final int[] arr;
    private int count;

    public MaxHeap(int length) {
        arr = new int[length];
        count = 0;
    }

    /**
     *
     * @param arr    堆数组
     * @param length 堆大小
     */
    private static void upAdjust(int[] arr, int length) {
        int cIndex = length - 1;
        int pIndex = (cIndex - 1) / 2;
        while (pIndex >= 0) {
            if (arr[cIndex] > arr[pIndex]) {
                swap(arr, pIndex, cIndex);
                cIndex = pIndex;
                pIndex = (cIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    /**
     *
     * @param arr      堆数组
     * @param pIndex   向下调整的下标
     * @param length   堆大小
     */
    private static void downAdjust(int[] arr, int pIndex, int length) {
        int cIndex = pIndex * 2 + 1;
        while (cIndex < length) {
            if (cIndex + 1 < length && arr[cIndex + 1] > arr[cIndex]) {
                cIndex ++;
            }
            if (arr[pIndex] < arr[cIndex]) {
                swap(arr, pIndex, cIndex);
                pIndex = cIndex;
                cIndex = pIndex * 2 + 1;
            } else {
                break;
            }
        }
    }

    /**
     *
     * @param arr     堆数组
     * @param length  堆大小
     */
    public static void buildHeap(int[] arr, int length) {
        for (int i = (length - 2) / 2; i >= 0; i --) {
            downAdjust(arr, i, length);
        }
    }

    public Integer pop() {
        if (count == 0) {
            return null;
        }
        int result = arr[0];
        arr[0] = arr[count - 1];
        downAdjust(arr, 0, -- count);
        return result;
    }

    public boolean push(int i) {
        if (count < arr.length) {
            arr[count] = i;
            upAdjust(arr, ++ count);
            return true;
        }
        return false;
    }

    public static void sort(int[] arr) {
        buildHeap(arr, arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            downAdjust(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


}
