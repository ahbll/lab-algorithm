package top.bhappy.learn.graph.graph.v1;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: liu lei
 * @Date: 2020/2/28 11:28
 * @Description:
 */
public class BreadthFirstSearch {

    public static void search(Graph graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] accesses = new boolean[graph.size];
        queue.add(start);
        accesses[start] = true;
        search(graph, queue, accesses);
    }

    public static void search(Graph graph, Queue<Integer> queue, boolean[] accesses) {
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            System.out.println(graph.vertices[index].data);
            for (Integer i : graph.adj[index]) {
                if (!accesses[i]) {
                    queue.add(i);
                    accesses[i] = true;
                }
            }
        }
    }


}
