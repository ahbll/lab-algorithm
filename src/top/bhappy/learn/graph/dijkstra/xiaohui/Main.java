package top.bhappy.learn.graph.dijkstra.xiaohui;


import java.util.Map;

/**
 * @Author: liu lei
 * @Date: 2020/2/24 17:51
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Dijkstra dijkstra1 = new top.bhappy.learn.graph.dijkstra.xiaohui.Dijkstra();
        Dijkstra dijkstra2 = new Dijkstra();
        Graph graph = new Graph(7);
        initGraph(graph);

        Map<Integer, Integer> distanceMap1 = dijkstra1.dijkstra(graph, 0);
        System.out.println(distanceMap1);
        Map<Integer, Integer> distanceMap2 = dijkstra2.dijkstra(graph, 0);
        System.out.println(distanceMap2);

        Map<Integer, Integer> distanceMap3 = dijkstra1.dijkstra(graph, 1);
        System.out.println(distanceMap3);
        Map<Integer, Integer> distanceMap4 = dijkstra2.dijkstra(graph, 1);
        System.out.println(distanceMap4);

        Map<Integer, Integer> distanceMap5 = dijkstra1.dijkstra(graph, 3);
        System.out.println(distanceMap5);
        Map<Integer, Integer> distanceMap6 = dijkstra2.dijkstra(graph, 3);
        System.out.println(distanceMap6);

    }

    private static void initGraph(Graph graph) {
        graph.vertices[0] = new Vertex("A");
        graph.vertices[1] = new Vertex("B");
        graph.vertices[2] = new Vertex("C");
        graph.vertices[3] = new Vertex("D");
        graph.vertices[4] = new Vertex("E");
        graph.vertices[5] = new Vertex("F");
        graph.vertices[6] = new Vertex("G");


        graph.adj[0].add(new Edge(1, 5));  //AB 5
        graph.adj[0].add(new Edge(2, 2));  //AC 2
        graph.adj[1].add(new Edge(0, 5));  //BA 5
        graph.adj[1].add(new Edge(3, 1));  //BD 1
        graph.adj[1].add(new Edge(4, 6));  //BE 6
        graph.adj[2].add(new Edge(0, 2));  //CA 2
        graph.adj[2].add(new Edge(3, 6));  //CD 6
        graph.adj[2].add(new Edge(5, 8));  //CF 8
        graph.adj[3].add(new Edge(1, 1));  //DB 1
        graph.adj[3].add(new Edge(2, 6));  //DC 6
        graph.adj[3].add(new Edge(4, 1));  //DE 1
        graph.adj[3].add(new Edge(5, 2));  //DF 2
        graph.adj[4].add(new Edge(1, 6));  //EB 6
        graph.adj[4].add(new Edge(3, 1));  //ED 1
        graph.adj[4].add(new Edge(6, 7));  //EG 7
        graph.adj[5].add(new Edge(2, 8));  //FC 8
        graph.adj[5].add(new Edge(3, 2));  //FD 2
        graph.adj[5].add(new Edge(6, 3));  //FG 3
        graph.adj[6].add(new Edge(4, 7));  //GE 7
        graph.adj[6].add(new Edge(5, 3));  //GF 3

        /*
        graph.adj[0].add(new Edge(2, 2));  //AC 2
        graph.adj[2].add(new Edge(3, 2));  //CD 2
        graph.adj[3].add(new Edge(1, 2));  //DB 2
        graph.adj[1].add(new Edge(4, 2));  //BE 2
        graph.adj[4].add(new Edge(6, 2));  //EG 2

        graph.adj[0].add(new Edge(1, 7));  //AB 7
        graph.adj[3].add(new Edge(4, 7));  //DE 7
        */

    }
}
