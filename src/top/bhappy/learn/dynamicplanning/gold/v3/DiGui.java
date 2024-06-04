package top.bhappy.learn.dynamicplanning.gold.v3;

import top.bhappy.learn.dynamicplanning.gold.v1.DiTui;

/**
 * @Author: liu lei
 * @Date: 2024/5/13 20:16
 * @Description:
 */
public class DiGui {

    public static void main(String[] args) {
        int w = 18;
        //金矿价值
        int[] g = {400, 500, 200, 300, 350};
        //用工人数
        int[] p = {5, 5, 3, 4, 3};

        int max = getMax(g, p, w);
        System.out.println(max);
    }


    public static int getMax(int[] golds, int[] workers, int worker) {
        return rGetMax(golds, workers, worker, golds.length - 1);
    }

    public static int rGetMax(int[] golds, int[] workers, int worker, int index) {

        if (index < 0) {
            return 0;
        }
        return Math.max((worker < workers[index] ? 0 : rGetMax(golds, workers, worker - workers[index], index - 1) + golds[index]),
                rGetMax(golds, workers, worker, index - 1));
    }

}
