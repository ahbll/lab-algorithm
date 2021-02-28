package top.bhappy.learn.sort.counting;

import top.bhappy.learn.sort.quick.v1.QuickSort;

import java.util.Date;
import java.util.Random;

/**
 * @Author: liu lei
 * @Date: 2021/2/18 15:55
 * @Description:
 */

// 计数排序
// 100000个人
// 分数 0分 ～ 99分
public class CountSort {
    public static void main(String[] args) {
        int[] arr1 = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr1[i] = random.nextInt(100);
        }
        int[] arr2 = new int[100000];
        for (int i = 0; i < 100000; i++) {
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
        //int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            //min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int bucketCount = max + 1;
        int[] buckets = new int[bucketCount];
        for (int i : arr) {
            buckets[i] ++;
        }
        for (int i = 0; i < bucketCount - 1; i++) {
            buckets[i + 1] = buckets[i] + buckets[i + 1];
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < buckets[j]) {
                arr[i] = j;
            } else {
                j ++;
            }
        }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 10000 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]);
            System.out.print("  ");
        }
    }

}
