package top.bhappy.learn.numberk;

/**
 * @Author: liu lei
 * @Date: 2020/2/25 15:29
 * @Description:
 */

/**
 * 最小堆的方式求数组中第k大数 --- 小灰
 */
public class MinHeap {

    /**
     * 寻找第k大的元素
     * @param array 待调整的堆
     * @param k 第几大
     * @return
     */
    public static int findNumberK(int[] array, int k) {
        //1.将数组前k和元素构建成最小堆
        buildHeap(array, k);
        //2.遍历数组剩下的元素，和堆顶比较，
        for(int i = k; i < array.length; i++) {
            if (array[0] < array[i]) {
                array[0] = array[i];
                downAdjust(array, 0, k);
            }
        }
        return array[0];
    }

    /**
     * 构建堆
     * @param array 待调整的堆
     * @param length 堆的有效大小
     */
    public static void buildHeap(int[] array, int length) {
        for (int i = (length - 2) / 2; i >= 0; i --) {
            downAdjust(array, i, length);
        }
    }

    /**
     * 下调的堆
     * @param array  待调整的堆
     * @param index  要下沉的节点
     * @param length  堆的有效大小
     */
    private static void downAdjust(int[] array, int index, int length) {
        int temp = array[index];
        int childIndex = 2 * index + 1;
        while(childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex ++;
            }
            //如果父节点小于任何一个孩子的值，直接跳出
            if(temp < array[childIndex]) {
                break;
            }
            //无需真正交换，单向赋值即可
            array[index] = array[childIndex];
            index = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[index] = temp;
    }

}
