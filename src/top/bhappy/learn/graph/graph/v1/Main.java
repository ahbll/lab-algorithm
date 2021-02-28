package top.bhappy.learn.graph.graph.v1;

/**
 * @Author: liu lei
 * @Date: 2020/2/28 13:39
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        Graph graph = buildGraph();

        DepthFirstSearch.search(graph, 0);

        System.out.println("--------------------");
        BreadthFirstSearch.search(graph, 0);

        System.out.println("+++++++++++++++++++++");

        MinPath.minPath(graph, 0);


    }

    public static Graph buildGraph() {
        Graph graph = new Graph(6);

        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);

        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);

        graph.adj[2].add(0);

        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);

        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);

        graph.adj[5].add(3);
        graph.adj[5].add(4);

        return graph;
    }
}
