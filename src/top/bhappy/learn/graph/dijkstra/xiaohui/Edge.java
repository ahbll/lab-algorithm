package top.bhappy.learn.graph.dijkstra.xiaohui;

/**
 * @Author: liu lei
 * @Date: 2020/2/24 17:52
 * @Description:
 */
/**
 * 图的边
 */
public class Edge {
    int index;
    int weight;
    Edge(int index, int weight) {
        this.weight = weight;
        this.index = index;
    }
}
