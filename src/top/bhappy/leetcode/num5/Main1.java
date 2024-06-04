package top.bhappy.leetcode.num5;

/**
 * @Author: liu lei
 * @Date: 2024/5/9 17:37
 * @Description:
 */
public class Main1 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i ++) {
            int d = 0;
            while (i - d >= 0 && i + d < s.length()) {
                if (s.charAt(i - d) != s.charAt(i + d)) {
                    break;
                }
                if (1 + 2 * d > result.length()) {
                    result = s.substring(i - d, i + d + 1);
                }
                d ++;
            }
            d = 0;
            while (i - d >= 0 && i + d + 1 < s.length()) {
                if (s.charAt(i - d) != s.charAt(i + d + 1)) {
                    break;
                }
                if (2 * d + 2 > result.length()) {
                    result = s.substring(i - d, i + d + 2);
                }
                d ++;
            }
        }
        return result;
    }
}
