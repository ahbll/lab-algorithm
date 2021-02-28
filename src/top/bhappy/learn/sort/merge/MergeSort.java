package top.bhappy.learn.sort.merge;

/**
 * @Author: liu lei
 * @Date: 2021/2/18 16:52
 * @Description:
 */

// 归并排序
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 1, 4, 0, 9, 7, 5, 8, 2, 6};
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int left, int right) {
        int[] tempArr = new int[right - left + 1];
        int mid = (left + right) / 2;
        int s1 = left;
        int s2 = mid + 1;
        int i = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2]) {
                tempArr[i] = arr[s1];
                s1 ++;
            } else {
                tempArr[i] = arr[s2];
                s2 ++;
            }
            i ++;
        }
        // 将剩余数据拷贝过来
        if (s1 > mid) {
            while (s2 <= right) {
                tempArr[i] = arr[s2];
                s2 ++;
                i ++;
            }
        }
        if (s2 > right) {
            while (s1 <= mid) {
                tempArr[i] = arr[s1];
                s1 ++;
                i ++;
            }
        }
        int k = left;
        for (int j = 0; j < tempArr.length; j ++) {
            arr[k] = tempArr[j];
            k ++;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 100 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]);
            System.out.print("  ");
        }
    }

}
