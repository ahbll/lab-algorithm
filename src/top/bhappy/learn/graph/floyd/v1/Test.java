package top.bhappy.learn.graph.floyd.v1;

/**
 * @Author: liu lei
 * @Date: 2020/3/2 14:25
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 5, 2, Floyd.INF, Floyd.INF, Floyd.INF, Floyd.INF},
                {5, 0, Floyd.INF, 1, 6, Floyd.INF, Floyd.INF},
                {2, Floyd.INF, 0, 6, Floyd.INF, 8, Floyd.INF},
                {Floyd.INF, 1, 6, 0, 1, 2, Floyd.INF},
                {Floyd.INF, 6, Floyd.INF, 1, 0, Floyd.INF, 7},
                {Floyd.INF, Floyd.INF, 8, 2, Floyd.INF, 0, 3},
                {Floyd.INF, Floyd.INF, Floyd.INF, Floyd.INF, 7, 3, 0}
        };
        Floyd.floyd(matrix);
    }

}
