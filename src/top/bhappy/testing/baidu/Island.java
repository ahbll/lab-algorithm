package top.bhappy.testing.baidu;

/**
 * @Author: liu lei
 * @Date: 2020/5/8 14:31
 * @Description:
 *
 * graph为一张地图，数字1代表陆地，0代表海洋
 * 求graph中的孤岛数量
 */
public class Island {

    static  int l = 5;
    static  int w = 5;
    static  int[][] graph = new int[][]{
            {1,1,1,1,1},
            {1,1,0,0,0},
            {1,1,1,0,1},
            {0,0,1,1,1},
            {1,1,1,0,0}
    };
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);


        int count = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] == 1) {
                    count++;
                    recur(i, j);
                }
            }
        }
        System.out.println(count);


    }

    public static void recur(int i, int j) {
        graph[i][j] = -1;

        if (i + 1 < l && graph[i + 1][j] == 1) {
            recur(i + 1, j);
        }
        if (i - 1 >= 0 && graph[i - 1][j] == 1) {
            recur(i - 1, j );
        }
        if (j + 1 < w && graph[i][j + 1] == 1) {
            recur(i, j + 1);
        }
        if (j - 1 >= 0 && graph[i][j - 1] == 1) {
            recur(i, j - 1);
        }

    }
}
