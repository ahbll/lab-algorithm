package top.bhappy.learn.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: liu lei
 * @Date: 2024/5/29 10:15
 * @Description:
 */
public class LC402 {

    public static void main(String[] args) {
        // System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("112", 1));
    }

    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if (len <= k) {
            return "0";
        }
        int i = 0;
        Deque<Character> queue = new LinkedList<>();
        while (i < len) {
            char c = num.charAt(i);
            while (queue.size() > 0 && queue.peekLast() > c && k > 0) {
                queue.pollLast();
                k --;
            }
            queue.offerLast(c);
            i ++;
        }
        StringBuffer buffer = new StringBuffer();
        boolean flag = false;
        while (queue.size() > k) {
            Character c = queue.pollFirst();
            if (c != '0') {
                flag = true;
            }
            if (flag) {
                buffer.append(c);
            }
        }
        return buffer.length() == 0 ? "0" : buffer.toString();

    }

}
