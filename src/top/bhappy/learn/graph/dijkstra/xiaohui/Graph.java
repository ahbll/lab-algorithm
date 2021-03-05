package top.bhappy.learn.graph.dijkstra.xiaohui;
import java.util.LinkedList;

/**
 * @Author: liu lei
 * @Date: 2020/2/24 17:52
 * @Description:
 */


/**
 * 图
 */
public class Graph {
    //顶点
    public Vertex[] vertices;
    //边
    public LinkedList<Edge> adj[];

    Graph(int size) {
        vertices = new Vertex[size];
        adj = new LinkedList[size];
        for(int i = 0; i < adj.length; i ++) {
            adj[i] = new LinkedList<Edge>();
        }
    }
}