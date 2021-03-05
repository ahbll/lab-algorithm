package top.bhappy.learn.graph.floyd.v2;


/**
 * @Author: liu lei
 * @Date: 2021/2/28 19:12
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 5, 2, top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF},
                {5, 0, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 1, 6, top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF},
                {2, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 0, 6, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 8, top.bhappy.learn.graph.floyd.v1.Floyd.INF},
                {top.bhappy.learn.graph.floyd.v1.Floyd.INF, 1, 6, 0, 1, 2, top.bhappy.learn.graph.floyd.v1.Floyd.INF},
                {top.bhappy.learn.graph.floyd.v1.Floyd.INF, 6, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 1, 0, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 7},
                {top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 8, 2, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 0, 3},
                {top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF, top.bhappy.learn.graph.floyd.v1.Floyd.INF, 7, 3, 0}
        };
        Floyd.transform(matrix);
        Floyd.print(matrix);

    }
}
