package top.bhappy.learn.substring;

/**
 * @Author: liu lei
 * @Date: 2020/12/31 14:51
 * @Description:
 */

//todo
public class KMP {

    public static void main(String[] args) {
        String src = "abcdabbacdababcabecd";
        String pattern = "ababc";
        int[] nextArr = {-1, 0, 0, 1, 2};
        int index = getIndex(src, pattern, nextArr);
        System.out.println(index);
    }

    private static int[] getNextArray(String pattern) {
        int[] nextArray = new int[pattern.length()];

        return nextArray;
    }

    public static int getIndex(String src, String pattern, int[] nextArray) {
        if (null == nextArray) {
            nextArray = getNextArray(pattern);
        }
        int i = 0;
        int j = 0;
        while (i < src.length() && j < pattern.length()) {
            if (j == -1 || src.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = nextArray[j];
            }
        }
        if (j >= pattern.length()) {
            return i - pattern.length();
        } else {
            return -1;
        }

    }

}
