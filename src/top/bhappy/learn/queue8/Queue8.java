package top.bhappy.learn.queue8;

/**
 * @Author: liu lei
 * @Date: 2020/1/12 20:24
 * @Description:
 */
public class Queue8 {

    private static int max;

    //{0,1,2,3,4,5,6,7}
    private static int[] array;

    private static int count;

    private static int count2;

    private static int count3;

    public static void main(String[] args) {
        max = 14;
        array = new int[max];
        check(0);
        System.out.println(count);
        System.out.println(count2);
        System.out.println(count3);

    }

    public static void check(int index) {
        count3++;
        if (index == max) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            count2++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[index] = i;
            boolean judge = judge(index);
            if (judge) {
                check(index + 1);
            }
        }

    }

    //index -- 行
    public static boolean judge(int index) {
        count++;
        for (int i = 0; i < index; i ++) {
            if (array[i] == array[index] || Math.abs(index - i) == Math.abs(array[index] - array[i])) {
                return false;
            }
        }
        return true;
    }


}
