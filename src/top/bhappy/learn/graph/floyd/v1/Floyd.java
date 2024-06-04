package top.bhappy.learn.graph.floyd.v1;

/**
 * @Author: liu lei
 * @Date: 2020/3/2 14:09
 * @Description:
 */
//佛洛依德
public class Floyd {

    public static final int INF = Integer.MAX_VALUE;

    public static void floyd(int[][] matrix) {
        //循环更新矩阵的值
        //k---经由的顶点
        //i---起点
        //j---终点
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][k] == INF || matrix[k][j] == INF) {
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println("");
        }
    }

}
