package top.bhappy.learn.graph.dijkstra.v1;

import java.util.*;

/**
 * @Author: liu lei
 * @Date: 2020/2/24 09:35
 * @Description:
 */

//迪克斯特拉---程序员小灰
public class Dijkstra {


    //小灰的
    public static Map<Integer, Integer> dijkstra(Graph graph, int startIndex) {
        //创建距离表，存储从起点到每一个顶点的零时距离
        Map<Integer, Integer> distanceMap = new HashMap<>();
        //记录遍历过的点
        Set<Integer> accessSet = new HashSet<>();
        //图的顶点数
        int size = graph.vertices.length;
        //初始化最短路径表，到达每个顶点的路径默认为无穷大
        for(int i = 1; i < size; i++) {
            if (i == startIndex) {
                distanceMap.put(i, 0);
            } else {
                distanceMap.put(i, Integer.MAX_VALUE);
            }
        }
        //遍历起点，刷新距离表
        accessSet.add(0);
        LinkedList<Edge> edgesFromStart = graph.adj[startIndex];
        for(Edge edge : edgesFromStart) {
            distanceMap.put(edge.index, edge.weight);
        }
        //主循环，重复 遍历最短距离顶点和刷新距离表
        for(int i = 1; i < size; i++) {
            //寻找最短距离顶点
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for(int j = 1; j < size; j++) {
                if(!accessSet.contains(j) && distanceMap.get(j) < minDistanceFromStart) {
                    minDistanceFromStart = distanceMap.get(j);
                    minDistanceIndex = j;
                }
            }
            if(minDistanceIndex == -1) {
                break;
            }
            //遍历顶点，刷新距离表
            accessSet.add(minDistanceIndex);
            for(Edge edge : graph.adj[minDistanceIndex]) {
                if(accessSet.contains(edge.index)) {
                    continue;
                }
                int weight = edge.weight;
                int preDistance = distanceMap.get(edge.index);
                if(weight != Integer.MAX_VALUE && (minDistanceFromStart + weight < preDistance)) {
                    distanceMap.put(edge.index, minDistanceFromStart + weight);
                }
            }
        }
        return distanceMap;
    }






}
