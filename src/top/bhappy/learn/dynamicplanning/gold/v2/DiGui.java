package top.bhappy.learn.dynamicplanning.gold.v2;

/**
 * @Author: liu lei
 * @Date: 2021/2/24 17:51
 * @Description:
 */
public class DiGui {

    /**
     * 挖金矿
     * 10名工人 ：w = 10
     * 金矿价值 ： g = [400, 500, 200, 300, 350]
     * 用工人数 ： p = [5, 5, 3, 4, 3]
     * */
    public static void main(String[] args) {
        int w = 10;
        //金矿价值
        int[] g = {400, 500, 200, 300, 350};
        //用工人数
        int[] p = {5, 5, 3, 4, 3};

        int max = max(g, p, w);
        System.out.println(max);
    }

    public static int max(int[] golds, int[] workers, int worker) {
        int goldNum = golds.length;
        return rMax(golds, workers, goldNum - 1, worker);
    }

    public static int rMax(int[] golds, int[] workers, int index, int worker) {
        // 边界条件
        if (index == 0) {
            return workers[index] > worker ? 0 : golds[index];
        }
        if (workers[index] > worker) {
            return rMax(golds, workers, index - 1, worker);
        }
        // 状态转换 缩减问题规模
        return Math.max(golds[index] + rMax(golds, workers, index - 1, worker - workers[index]),
                rMax(golds, workers, index - 1, worker));
    }

}
