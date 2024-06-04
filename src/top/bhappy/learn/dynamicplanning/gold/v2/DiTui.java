package top.bhappy.learn.dynamicplanning.gold.v2;

/**
 * @Author: liu lei
 * @Date: 2021/2/24 17:52
 * @Description:
 */

import java.util.Arrays;

/**
 * 挖金矿
 * 10名工人 ：w = 10
 * 5个金矿 ： n = 5
 * 金矿价值 ： g = [400, 500, 200, 300, 350]
 * 用工人数 ： p = [5, 5, 3, 4, 3]
 * 求最多能获得多少黄金
 */

public class DiTui {

    public static void main(String[] args) {
        //工人数
        int w = 100;
        //金矿数
        int n = 5;
        //金矿价值
        int[] g = {400, 500, 200, 300, 350};
        //用工人数
        int[] p = {5, 5, 3, 4, 3};

        int max = getMax(g, p, w);
        System.out.println(max);
    }

    public static int getMax(int[] golds, int[] workers, int worker) {
        int goldNum = golds.length;
        //i个金矿数能获取最大黄金数
        int[] cur = new int[worker + 1];
        //i-1个金矿能获取最大黄金数
        int[] pre = new int[worker + 1];

        //边界：1个金矿能获取最大黄金数
        for (int i = 0; i < worker + 1; i++) {
            if (workers[0] > i) {
                pre[i] = 0;
            } else {
                pre[i] = golds[0];
            }
        }
        if (goldNum == 1) {
            return pre[worker];
        }
        //递推
        for (int i = 1; i < goldNum; i++) {
            for (int j = 0; j < worker + 1; j++) {
                if (j < workers[i]) {
                    cur[j] = pre[j];
                } else {
                    cur[j] = Math.max(pre[j], golds[i] + pre[j - workers[i]]);
                }
            }
            pre = Arrays.copyOf(cur, cur.length);
        }

        return cur[worker];
    }


}
