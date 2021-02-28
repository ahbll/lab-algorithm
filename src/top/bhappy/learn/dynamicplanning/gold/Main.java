package top.bhappy.learn.dynamicplanning.gold;

/**
 * @Author: liu lei
 * @Date: 2020/4/3 14:40
 * @Description:
 */


import top.bhappy.learn.dynamicplanning.gold.v1.DiGui;
import top.bhappy.learn.dynamicplanning.gold.v1.DiTui;

/**
 * 挖金矿
 * 10名工人 ：w = 10
 * 5个金矿 ： n = 5
 * 金矿价值 ： g = [400, 500, 200, 300, 350]
 * 用工人数 ： p = [5, 5, 3, 4, 3]
 * 求最多能获得多少黄金
 *
 * 动态规划: 1、最优子结构；2、状态转移公式；3、边界 ==》递推：1、初始条件；2、递推关系
 *                                            ==》递归：1、基线条件；2、递归关系
 */


public class Main {

    public static void main(String[] args) {
        //工人数
        int w = 100;
        //金矿数
        int n = 5;
        //金矿价值
        int[] g = {400, 500, 200, 300, 350};
        //用工人数
        int[] p = {5, 5, 3, 4, 3};

        int max1 = DiTui.max(n, w, g, p);
        System.out.println(max1);

        int max2 = DiGui.max(n, w, g, p);
        System.out.println(max2);



    }

}
