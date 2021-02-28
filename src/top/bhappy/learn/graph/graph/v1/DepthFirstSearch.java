package top.bhappy.learn.graph.graph.v1;

import java.util.LinkedList;

/**
 * @Author: liu lei
 * @Date: 2020/2/28 11:27
 * @Description:
 */
public class DepthFirstSearch {

    public static void search(Graph graph, int start) {
        search(graph, start, new boolean[graph.vertices.length]);
    }

    public static void search(Graph graph, int start, boolean[] accesses) {
        if (accesses[start]) {
            return;
        }
        System.out.println(graph.vertices[start].data);
        LinkedList<Integer> adjList = graph.adj[start];
        accesses[start] = true;
        for (Integer index : adjList) {
            search(graph, index, accesses);
        }
        //accesses[start] = true;
    }

}
