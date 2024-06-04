package top.bhappy.learn.dynamicplanning.gold.v3;

/**
 * @Author: liu lei
 * @Date: 2024/5/14 10:15
 * @Description:
 */
public class DiTui {

    public static void main(String[] args) {
        //工人数
        int w = 10;
        //金矿数
        int n = 5;
        //金矿价值
        int[] g = {400, 500, 200, 300, 350};
        //用工人数
        int[] p = {5, 5, 3, 4, 3};

        int max = getMax(g, p, w);
        System.out.println(max);


    }

    private static int getMax(int[] g, int[] p, int w) {
        int goldNum = g.length;
        int[] pre;
        int[] cur = new int[w + 1];
        // 初始化基线条件
        for (int i = 0; i < w + 1; i ++) {
           if (i < p[0]) {
               cur[i] = 0;
           } else {
               cur[i] = g[0];
           }
        }
        print(cur);
        // 递推
        // 循环金矿数量
        for (int i = 1; i < goldNum; i ++) {
            pre = cur;
            // 这里一定要重置数组
            cur = new int[w + 1];
            // 循环工人数量
            for (int j = 0 ; j < w + 1; j ++) {
                // 工人数量少于第i个金矿所需的工人数量
                if (j < p[i]) {
                    cur[j] = pre[j];
                } else {
                    cur[j] = Math.max(pre[j], pre[j - p[i]] + g[i]);
                }
            }
            print(cur);
        }
        return cur[w];
    }

    private static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
