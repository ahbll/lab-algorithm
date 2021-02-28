package top.bhappy.nk.huawei;

/**
 * @Author: liu lei
 * @Date: 2020/4/6 22:18
 * @Description:
 */

/**
 *
 * 有问题
 */

import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] array = s.split("\\s+");
            int money = Integer.parseInt(array[0]);
            int num = Integer.parseInt(array[1]);
            int[] prices = new int[num + 1];
            int[] weights = new int[num + 1];
            int[] refers = new int[num + 1];
            for (int i = 1; i < num + 1; i ++) {
                String item = sc.nextLine();
                String[] arr = item.split("\\s+");
                //价格
                prices[i] = Integer.parseInt(arr[0]);
                //权重
                weights[i] = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
                //所属主件
                refers[i] = Integer.parseInt(arr[2]);
            }
            int len = money / 10 + 1;
            int[][] res = new int[num + 1][len];
            for (int i = 0; i < len; i++) {
                res[0][i] = 0;
                if (10 * i < prices[1]) {
                    res[1][i] = 0;
                } else {
                    res[1][i] = weights[1];
                }
            }
            //辗转计算currenWeight
            //假设物品清单按照 主件1， 主件1@附件1， 主件1@附件2，主件2， 主件2@附件1 的顺序输入
            //如果非按照上述顺序，则需排序
            for (int i = 2; i < num + 1; i ++) {
                for (int j = 0; j < len; j ++) {
                    //主件
                    if (refers[i] == 0) {
                        if (10 * len < prices[i]) {
                            res[i][j] = res[i - 1][j];
                        } else {
                            res[i][j] = Math.max((weights[i] + res[i - 1][len - prices[i] / 10]), res[i - 1][j]);
                        }
                    }
                    //附件
                    else {
                        if (10 * j < prices[i] + prices[refers[i]]) {
                            res[i][j] = res[i - 1][j];
                        } else {
                            if (i - refers[i] == 1) {
                                //主件 + 第一件附件
                                int w = weights[i] + weights[i - 1] + res[i - 2][j - prices[i] / 10 - prices[i - 1] / 10];
                                //最大值
                                res[i][j] = Math.max(w, res[i - 1][j]);
                            } else {
                                if (prices[i] + prices[i - 1] + prices[i - 2] < j) {
                                    //主件 + 第二件附件
                                    int w = weights[i] + weights[i - 2] + res[i - 3][len - prices[i] / 10 - prices[ i - 2] / 10];
                                    //最大值
                                    res[i][j] = Math.max(w, res[i - 1][j]);
                                } else {
                                    //主件+附件1+附件2
                                    int w1 = weights[i] + weights[i - 1] + weights[i - 2] +
                                            res[i - 3][len - prices[i] / 10 - prices[i - 2] / 10 - prices[i - 3] / 10];
                                    //主件+附件2
                                    int w2 = weights[i] + weights[i - 2] + res[i - 3][len - prices[i] / 10 - prices[i-2] / 10];
                                    //最大值
                                    res[i][j] = Math.max(Math.max(w1, w2), res[i - 1][j]);
                                }
                            }
                        }
                    }

                }
            }
            System.out.println(res[num][len - 1]);
        }
    }
}