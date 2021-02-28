package top.bhappy.learn.graph.graph.v1;

import java.util.LinkedList;

/**
 * @Author: liu lei
 * @Date: 2020/2/28 11:12
 * @Description:
 */
public class Graph {

    public int size;

    public Vertex[] vertices;

    public LinkedList<Integer>[] adj;

    public Graph(int size) {
        this.size = size;
        //初始化顶点和临接矩阵
        vertices = new Vertex[size];
        adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            vertices[i] = new Vertex(i);
            adj[i] = new LinkedList<>();
        }
    }

}
