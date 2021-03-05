package top.bhappy.learn.graph.floyd.v2;

/**
 * @Author: liu lei
 * @Date: 2021/2/28 18:45
 * @Description:
 */

//佛洛依德
public class Floyd {

    public static final int INF = Integer.MAX_VALUE;

    public static void transform(int[][] matrix) {
        int count = matrix.length;
        //依次加入中点，并更新矩阵
        //k---可经过的顶点
        //j---终点
        //i---起点
        for (int k = 0; k < count; k ++) {
            for (int i = 0; i < count; i ++) {
                for (int j = 0; j < count; j ++) {
                    if (matrix[i][k] == INF || matrix[k][j] == INF) {
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length; j ++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println("");
        }
    }

}
