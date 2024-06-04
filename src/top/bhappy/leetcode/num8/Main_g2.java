package top.bhappy.leetcode.num8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liu lei
 * @Date: 2024/5/11 15:06
 * @Description:
 * self  : false
 */
public class Main_g2 {

    public static void main(String[] args) {
        System.out.println(myAtoi("-9098899000"));
        System.out.println(myAtoi("5544415852544"));
        System.out.println(myAtoi("-90988afdcas"));
        System.out.println(myAtoi("5544415xxx"));
    }

    private static int myAtoi(String number) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < number.length(); i++) {
            automaton.get(number.charAt(i));
        }
        return (int)(automaton.sign * automaton.res);
    }

    /**
     * 状态机
     * 1、状态（属性）
     * 2、状态转换（规则）
     * 3、数据（属性）
     */
    public static class Automaton {

        // 符号 1:正数，0:负数（数据）
        int sign = 1;

        // 结果（数据）
        public long res;

        // 状态
        public String state = "start";

        public void get(char c) {
            state = transMap.get(state)[getCol(c)];
            if ("in_number".equals(state)) {
                res = res * 10 + c - '0';
                res = sign == 1 ? Math.min(res, (long) Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }


        // 状态转换（规则）
        private Map<String, String[]> transMap = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        // 输入与转换的映射
        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }

    }


}
