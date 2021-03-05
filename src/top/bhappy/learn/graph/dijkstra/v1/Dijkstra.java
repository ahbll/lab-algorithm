package top.bhappy.learn.graph.dijkstra.v1;

import java.util.*;

/**
 * @Author: liu lei
 * @Date: 2020/2/24 09:35
 * @Description:
 */

//迪克斯特拉---ll
public class Dijkstra {


    /**
     * Dijkstra最短路径算法
     */
    public static Map<Integer, Integer> dijkstra(Graph graph, int startIndex) {

        int size = graph.vertices.length;

        //startIndex到各个节点的距离
        //可以使用数组
        HashMap<Integer, Integer> distanceMap = new HashMap<>();

        //已经遍历过的节点
        //可以使用数组
        HashSet<Integer> accessSet = new HashSet<>();

        //前一个节点
        int[] preVertex = new int[size];

        //初始化距离为∞
        for (int i = 0; i < size; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        //到自己的距离为0
        distanceMap.put(startIndex, 0);
        //先遍历startIndex
        accessSet.add(startIndex);
        preVertex[startIndex] = -1;
        LinkedList<Edge> startIndexEdges = graph.adj[startIndex];
        for (Edge edge : startIndexEdges) {
            distanceMap.put(edge.index, edge.weight);
            preVertex[edge.index] = startIndex;
        }
        while (accessSet.size() < size) {
            //距离start最近的index
            Integer minIndex = -1;
            //距离start最近的距离
            Integer minDistance = Integer.MAX_VALUE;
            //找到最小的distance
            for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
                if (!accessSet.contains(entry.getKey()) && entry.getValue() < minDistance) {
                    minIndex = entry.getKey();
                    minDistance = entry.getValue();
                }
            }
            //开始遍历minIndex
            accessSet.add(minIndex);
            LinkedList<Edge> edges = graph.adj[minIndex];
            for(Edge edge : edges) {
                if (distanceMap.get(edge.index) > minDistance + edge.weight) {
                    distanceMap.put(edge.index, minDistance + edge.weight);
                    preVertex[edge.index] = minIndex;
                }
            }

        }
        System.out.println(Arrays.toString(preVertex));
        return distanceMap;
    }



}
