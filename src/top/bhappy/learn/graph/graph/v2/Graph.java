package top.bhappy.learn.graph.graph.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liu lei
 * @Date: 2021/2/28 12:24
 * @Description:
 */
public class Graph {

    public int size;

    // 顶点
    public Vertex[] vertices;

    // 指向的节点列表
    public List<Integer>[] adj1;

    // 被指向的节点列表
    public List<Integer>[] adj2;

    public Graph(int size) {
        this.size = size;
        vertices = new Vertex[size];
        adj1 = new List[size];
        adj2 = new List[size];

        for (int i = 0; i < size; i ++) {
            vertices[i] = new Vertex(i);
            adj1[i] = new ArrayList<>();
            adj2[i] = new ArrayList<>();
        }
    }

}
