package top.bhappy.testing.huawei.v2.m1;

import java.util.Stack;

/**
 * @Author: liu lei
 * @Date: 2021/3/15 19:55
 * @Description:
 */

/**
 * 字符串s只包含{、}、(、)、[、]，判断该字符串是否符合规则---({[]})
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(check(s));
    }

    private static boolean check(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if ((c == ')' && pop != '(') || (c == ']' && pop != '[') || (c == '}' && pop != '{')) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

}
