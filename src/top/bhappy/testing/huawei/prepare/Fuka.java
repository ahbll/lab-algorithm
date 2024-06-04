package top.bhappy.testing.huawei.prepare;

/**
 * @Author: liu lei
 * @Date: 2020/4/7 15:06
 * @Description:
 */

import java.util.Collections;
import java.util.Scanner;

/**
 * 题目：以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡，单类型福卡不超过1张，随机抽取一个小于10人团队，求该团队最多可以集齐多少套五福？
 * 输入描述:
 * 输入若干个"11010"、”00110"的由0、1组成的长度等于5位字符串,代表的指定团队中每个人福卡获得情况
 * 注意1：1人也可以是一个团队
 * 注意2：1人可以有0到5张福卡，但福卡不能重复
 * <p>
 * 输出描述:
 * 输出该团队能凑齐多少套五福
 * <p>
 * 示例1
 * 输入
 * 11001
 * 输出
 * 0
 */

public class Fuka {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = Integer.parseInt(scanner.nextLine());
            int[] res = new int[]{0, 0, 0, 0, 0};
            for (int i = 0; i < count; i++) {
                String s = scanner.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    int value = Integer.parseInt(s.charAt(j) + "");
                    res[j] = res[j] + value;
                }
            }
            int min = count;
            for (int i = 0; i < res.length; i++) {
                if (res[i] < min) {
                    min = res[i];
                }
            }
            System.out.println(min);
        }
    }


}
