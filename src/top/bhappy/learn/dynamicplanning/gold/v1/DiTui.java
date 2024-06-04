package top.bhappy.learn.dynamicplanning.gold.v1;

import java.util.Arrays;

/**
 * @Author: liu lei
 * @Date: 2020/4/3 14:32
 * @Description:
 */


public class DiTui {

    public static int max(int n, int w, int[] g, int[] p) {
        //index = i；代表有i个工人最多能挖多少金币
        int[] preResults = new int[w + 1];
        int[] results = new int[w + 1];

        //填充边界格子值
        for (int i = 0; i < w + 1; i++) {
            if (i < p[0]) {
                preResults[i] = 0;
            } else {
                preResults[i] = g[0];
            }
        }
        if (n == 1) {
            return preResults[preResults.length - 1];
        }


        //填充其余格子的值，外层循环金矿数量，内层循环工人数
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (j < p[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
                }
            }
            preResults = Arrays.copyOf(results, results.length);
        }
        return results[w];
    }

}
