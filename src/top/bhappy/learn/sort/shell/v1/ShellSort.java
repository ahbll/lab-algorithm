package top.bhappy.learn.sort.shell.v1;

import java.util.Random;

/**
 * @Author: liu lei
 * @Date: 2021/3/9 20:04
 * @Description:
 */
public class ShellSort {

    public static void main(String[] args) {
        //int[] array = {0,9,8,6,7,1,2,4,5,0,3};
        //int[] array = {9, 8, 11};
        //int[] array = {3, 2, 1, 4, 5, 7, 8, 11, 9, 10, 6};
        int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            array[i] = random.nextInt(10000);
        }
        sort(array);
        for (int i : array) {
            //System.out.println(i);
        }
    }

    // 0 1 2 3 4 5 6 -1
    public static void sort(int[] arr) {
        //步长从length/2开始，每次步长减半，循环所有步长
        int count = 0;
        for (int step = arr.length / 2; step > 0; step = step / 2) {
            //循环步长内每个起点
            for (int i = 0; i < step; i++) {
                //插入排序
                for(int j = i; j < arr.length; j += step) {
                    int temp = arr[j];
                    for (int k = j - step; k >= i; k -= step) {
                        count ++;
                        if (arr[k] > temp) {
                            arr[k + step] = arr[k];
                        } else {
                            //放到第一个不大于temp的后一个
                            arr[k + step] = temp;
                            break;
                        }
                        //全部数据都大于temp，放至第一个
                        arr[k] = temp;
                    }
                }
            }
        }
        System.out.println(count + "------------");
    }


}
