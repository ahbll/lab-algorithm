package top.bhappy.learn.sort.bucket;

import top.bhappy.learn.sort.quick.v1.QuickSort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author: liu lei
 * @Date: 2021/2/18 11:46
 * @Description:
 */

// 10000000件商品
// 价格 0000分 ～ 9999分
// 桶排序
public class BucketSort {
    public static void main(String[] args) {
        int[] arr1 = new int[10000000];
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            arr1[i] = random.nextInt(10000);
        }
        int[] arr2 = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arr2[i] = arr1[i];
        }

        long t1 = new Date().getTime();
        sort(arr1);
        long t2 = new Date().getTime();
        System.out.println();
        System.out.println(t2 - t1);
        //print(arr1);

        System.out.println("--------------------------------------------------------");

        long t3 = new Date().getTime();
        QuickSort.sort(arr2);
        long t4 = new Date().getTime();
        System.out.println();
        System.out.println(t4 - t3);
        //print(arr2);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // 创建桶
        int bucketCount = (max - min) / 100 + 1;
        List<Integer>[] buckets = new List[bucketCount];
        for (int i = 0; i < bucketCount; i ++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i : arr) {
            int num = i / 100;
            buckets[num].add(i);
        }
        //排序
        int index = 0;
        for (List<Integer> list : buckets) {
            if (!list.isEmpty()) {
                int[] array = new int[list.size()];
                for (int i = 0; i < array.length; i ++) {
                    array[i] = list.get(i);
                }
                QuickSort.sort(array);
                for (int i = 0; i < array.length; i++) {
                    arr[index] = array[i];
                    index ++;
                }
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 100000 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]);
            System.out.print("  ");
        }
    }


}
