package top.bhappy.testing.huawei.second;

import java.util.*;

/**
 * @Author: liu lei
 * @Date: 2021/3/1 00:00
 * @Description:
 */

// 86.96

/**
 * 字符串 包含 数字、字母
 * 求只包含一个字母的子串的最大长度
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isLetter(c)) {
                    list.add(i);
                }
            }
            if (list.size() == line.length() || list.size() == 0) {
                System.out.println(-1);
                continue;
            }
            int max = 0;
            for (int i = 0; i < list.size() - 2; i++) {
                if (list.get(i + 2) - list.get(i) - 1 > max) {
                    max = list.get(i + 2) - list.get(i) - 1;
                }
            }
            max = Math.max(max, list.get(0) + 1);
            if (list.get(0) == 0 && list.size() > 1) {
                max = Math.max(max, list.get(1));
            }
            if (list.get(0) > 0 && list.size() > 1) {
                max = Math.max(max, list.get(1));
            }
            max = Math.max(max, line.length() - list.get(list.size() - 1));

            System.out.println(max);
        }
    }
}