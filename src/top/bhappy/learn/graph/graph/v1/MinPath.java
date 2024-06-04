package top.bhappy.learn.graph.graph.v1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liu lei
 * @Date: 2020/3/1 18:30
 * @Description:
 */
public class MinPath {

    public static void minPath(Graph graph, int start) {

        //每个顶点距离起点的阶
        int[] ord = new int[graph.size];
        //在遍历中每个顶点的前一个顶点
        int[] pre = new int[graph.size];

        //队列
        Queue<Integer> queue = new LinkedList<>();
        //i是否被遍历过
        boolean[] accesses = new boolean[graph.size];

        //start节点
        ord[start] = 0;
        //-1代表起始节点
        pre[start] = -1;
        queue.add(start);
        //必须入队的时候设置，不然会存在多次入队的bug
        accesses[start] = true;

        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            for (Integer i : graph.adj[index]) {
                if (!accesses[i]) {
                    pre[i] = index;
                    ord[i] = ord[index] + 1;
                    queue.add(i);
                    accesses[i] = true;
                }
            }
        }

        // 阶
        System.out.println("order: " + Arrays.toString(ord));
        // 前一个顶点
        System.out.println("pre: " + Arrays.toString(pre));
    }


}
