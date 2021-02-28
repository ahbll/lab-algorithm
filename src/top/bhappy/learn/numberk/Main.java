package top.bhappy.learn.numberk;

/**
 * @Author: liu lei
 * @Date: 2020/2/27 14:23
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        int[] array1 = new int[]{7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8, 10, 2, 0, 19};
        System.out.println(MinHeap.findNumberK(array1, 5));
        int[] array2 = new int[]{7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8, 10, 2, 0, 19};
        System.out.println(D_C.findNumberK(array2, 5));
    }

}
