package top.bhappy.learn.dynamicplanning.gold.v1;

/**
 * @Author: liu lei
 * @Date: 2020/4/3 14:32
 * @Description:
 */

/**
 * 挖金矿
 * 10名工人 ：w = 10
 * 5个金矿 ： n = 5
 * 金矿价值 ： g = [400, 500, 200, 300, 350]
 * 用工人数 ： p = [5, 5, 3, 4, 3]
 * 求最多能获得多少黄金
 */

public class DiGui {
    static int n;
    static int w;
    static int[] g;
    static int[] p;

    public static int max(int n, int w, int[] g, int[] p) {
        DiGui.n = n;
        DiGui.w = w;
        DiGui.g = g;
        DiGui.p = p;

        return rMax(n, w);
    }

    //递归
    //可以通过map备忘录减少重复计算---优化
    public static int rMax(int num, int worker) {
        if (num == 1) {
            return p[0] > worker ? 0 : g[0];
        }
        if (p[num - 1] > worker) {
            return rMax(num - 1, worker);
        } else {
            return Math.max(rMax(num - 1, worker), rMax(num - 1, worker - p[num - 1]) + g[num - 1]);
        }
    }
}
