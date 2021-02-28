package top.bhappy.testing.smartx;

/**
 * @Author: liu lei
 * @Date: 2020/7/21 23:39
 * @Description:
 */

// 1 - N 中，x(0-9) 出现的次数。
// 如果一个数字中，x出现多次就计算为多次。
// 比如 1-2593, 求数字5出现的次数，其中 555 是在这个范围内的，这个数字里 5 算出现了3次。
// 要求代码的算法复杂度尽可能的低。
public class Test2 {
    public static void main(String[] args) {
        //System.out.println(getMaxCount(24, 2));
        //System.out.println(getMaxCount(1024, 2));
        System.out.println(getMaxCount2(24, 2));
        System.out.println(getMaxCount2(1024, 2));

    }

    public static int getMaxCount(int n, int x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            s = s.append(i);
        }
        int count = 0;
        char c = (x + "").charAt(0);
        for (int i = 0; i < s.length(); i ++) {
            if (c == s.charAt(i)) {
                count ++;
            }
        }
        return count;
    }

    public static int getMaxCount2(int n, int x) {
        int count = 0;
        if (n < x) {
            return 0;
        }

        for (int i = 0; i < n; i ++) {
            int j = i;
            while (j > 0) {
                int k = j % 10;
                if (k == x) {
                    count ++;
                }
                j = j / 10;
            }
        }
        return count;
    }
}
