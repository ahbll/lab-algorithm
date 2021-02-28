package top.bhappy.learn.graph.graph.v2;

import java.util.*;

/**
 * @Author: liu lei
 * @Date: 2021/2/28 12:24
 * @Description:
 */
public class Graphs {

    /**
     * 广度优先遍历
     * @param graph
     * @param start
     */
    public static void breadthFirstSearch(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] accesses = new boolean[graph.size];
        queue.add(start);
        accesses[start] = true;
        search(graph, queue, accesses);
    }

    private static void search(Graph graph, Queue<Integer> queue, boolean[] accesses) {
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            System.out.println(graph.vertices[index].data);
            for (Integer i : graph.adj1[index]) {
                if (!accesses[i]) {
                    queue.add(i);
                    accesses[i] = true;
                }
            }
        }
    }

    /**
     * 深度优先遍历
     * @param graph
     * @param start
     */
    public static void depthFirstSearch(Graph graph, int start) {
        boolean[] accesses = new boolean[graph.size];
        search(graph, start, accesses);
    }
    private static void search(Graph graph, int index, boolean[] accesses) {
        if (!accesses[index]) {
            accesses[index] = true;
            System.out.println(graph.vertices[index].data);
            for (int i : graph.adj1[index]) {
                search(graph, i, accesses);
            }
        }
    }


    /**
     * 最短路径
     * @param graph
     * @param start
     * @param end
     */
    public static void minPath(Graph graph, int start, int end) {
        //用于广度优先遍历
        Queue<Integer> queue = new LinkedList<>();
        //是否被遍历过
        boolean[] accesses = new boolean[graph.size];
        //每一个顶点的阶
        int[] orders = new int[graph.size];
        //遍历过程中每一个顶点的前一个顶点
        int[] pres = new int[graph.size];
        //初始化start顶点
        queue.add(start);
        accesses[start] = true;
        orders[start] = 0;
        pres[start] = -1;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            //System.out.println(graph.vertices[curr]);
            for (int i : graph.adj1[curr]) {
                if (!accesses[i]) {
                    queue.add(i);
                    accesses[i] = true;
                    orders[i] = orders[curr] + 1;
                    pres[i] = curr;
                }
            }
        }

        // 阶
        System.out.println("orders: " + Arrays.toString(orders));
        // 前一个顶点
        System.out.println("pres: " + Arrays.toString(pres));
        //路径
        List<Integer> paths = new ArrayList<>();
        int curr = end;
        while (curr != start) {
            paths.add(curr);
            curr = pres[curr];
        }
        paths.add(start);
        Collections.reverse(paths);
        System.out.println("paths: " + Arrays.toString(paths.toArray()));

    }



}
