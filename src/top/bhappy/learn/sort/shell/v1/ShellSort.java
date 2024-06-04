package top.bhappy.learn.sort.shell.v1;

import java.util.Date;
import java.util.Random;

/**
 * @Author: liu lei
 * @Date: 2021/3/9 20:04
 * @Description:
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};

        sort(array);

        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    // 0 1 2 3 4 5 6 -1
    public static void sort(int[] arr) {
        //步长从length/2开始，每次步长减半，循环所有步长
        int count = 0;
        for (int step = arr.length / 2; step > 0; step = step / 2) {
            //循环步长内每个起点
            for (int i = 0; i < step; i++) {
                //插入排序
                //在大多数元素已经有序的情况下，插入排序的工作量较小
                //在元素数量较少的情况下，插入排序的工作量较小
                for (int j = i + step; j < arr.length; j += step) {
                    int temp = arr[j];
                    for (int k = j - step; k >= i; k -= step) {
                        count++;
                        if (arr[k] > temp) {
                            arr[k + step] = arr[k];
                        } else {
                            //放到第一个不大于temp的后一个
                            arr[k + step] = temp;
                            //经过前几次排序，当step=1时，数组有序度较高，此处可以break掉大量循环
                            break;
                        }
                        //全部数据都大于temp，放至第一个
                        arr[k] = temp;
                    }
                }
            }
        }
        System.out.println("count：" + count);
    }

}
