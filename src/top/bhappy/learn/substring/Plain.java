package top.bhappy.learn.substring;

/**
 * @Author: liu lei
 * @Date: 2020/12/31 15:35
 * @Description:
 */
public class Plain {

    public static void main(String[] args) {
        String s1 = "abababcd";
        String s2 = "abcd";
        int index = getIndex(s1, s2);
        System.out.println(index);
    }


    public static int getIndex(String src, String pattern) {
        int k = 0;
        int i = 0;
        int j = 0;
        int srcLen = src.length();
        int patternLen = pattern.length();
        while (k <= srcLen - patternLen) {
            while (i < srcLen && j < patternLen) {
                if (src.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j < patternLen - 1) {
                k++;
                i = k;
                j = 0;
            } else {
                return k;
            }
        }
        return -1;
    }


}
