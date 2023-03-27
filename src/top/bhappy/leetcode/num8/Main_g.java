package top.bhappy.leetcode.num8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liu lei
 * @Date: 2023/3/27 17:01
 * @Description:
 */
public class Main_g {

    public static void main(String[] args) {
        System.out.println(myAtoi("-9098899000"));
        System.out.println(myAtoi("5544415852544"));
    }

    public static int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < str.length(); i ++) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    // 状态机
    public static class Automaton {
        // 状态
        private String state = "start";
        // 符号
        private int sign = 1;
        // 值
        private long ans = 0;

        public static Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[getCol(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }
        // 状态转移 0：' '， 1：+/-，2：number，3：other
        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (c <= '9' && c >= '0') {
                return 2;
            }
            return 3;
        }





    }


}
