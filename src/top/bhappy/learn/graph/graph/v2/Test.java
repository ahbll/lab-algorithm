package top.bhappy.learn.graph.graph.v2;

/**
 * @Author: liu lei
 * @Date: 2021/2/28 12:24
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        Graph graph = buildGraph();
        Graphs.breadthFirstSearch(graph, 0);

        System.out.println("----------------------");

        Graphs.depthFirstSearch(graph, 0);

        System.out.println("-----------------------");

        Graphs.minPath(graph, 0, 5);

    }

    public static Graph buildGraph() {
        Graph graph = new Graph(6);

        graph.adj1[0].add(1);
        graph.adj1[0].add(2);
        graph.adj1[0].add(3);

        graph.adj1[1].add(0);
        graph.adj1[1].add(3);
        graph.adj1[1].add(4);

        graph.adj1[2].add(0);

        graph.adj1[3].add(0);
        graph.adj1[3].add(1);
        graph.adj1[3].add(4);
        graph.adj1[3].add(5);

        graph.adj1[4].add(1);
        graph.adj1[4].add(3);
        graph.adj1[4].add(5);

        graph.adj1[5].add(3);
        graph.adj1[5].add(4);

        return graph;
    }

}
