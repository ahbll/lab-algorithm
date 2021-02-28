package top.bhappy.learn.sort.radix;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author: liu lei
 * @Date: 2021/2/18 16:05
 * @Description:
 */

// 基数排序
// 手机号
// 100000个手机号
// 从低未到高位排11次
public class RadixSort {

    public static void main(String[] args) {
        int num = 100000;
        long[] arr = new long[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            arr[i] = 10000000000L + random.nextInt(1000000000);
        }

        //基数排序
        long t1 = new Date().getTime();
        sort(arr, 11);
        long t2 = new Date().getTime();
        System.out.println(t2 - t1);;
        //print(arr);

        long t3 = new Date().getTime();
        //QuickSort3.sort(arr);
        long t4 = new Date().getTime();
        System.out.println(t4 - t3);;
    }

    public static void sort(long[] arr, int bound) {
        for (int i = 1; i <= bound; i++) {
            sortIndex(arr, i);
        }

    }

    // index从后向前
    public static void sortIndex(long[] arr, int index) {
        List<Long>[] buckets = new List[10];
        for (long l : arr) {
            long result = l;
            int i = index;
            int remain = 0;
            while (i > 0) {
                remain = (int) (result % 10);
                result = result / 10;
                i --;
            }
            if (buckets[remain] == null) {
                buckets[remain] = new ArrayList<>();
            }
            buckets[remain].add(l);
        }
        int i = 0;
        for (List<Long> list : buckets) {
            if (list != null) {
                for (Long l : list) {
                    arr[i] = l;
                    i ++;
                }
            }
        }
    }

    public static void print(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 100 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]);
            System.out.print("  ");
        }
    }

}
