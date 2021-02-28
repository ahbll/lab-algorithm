package top.bhappy.learn.factorial;

/**
 * @Author: liu lei
 * @Date: 2020/1/13 19:31
 * @Description:
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(loop(10));
        System.out.println(recursion(10));
    }

    public static int loop(int n) {
        int result = 1;
        while (n > 0) {
            result = result * n;
            n--;
        }
        return result;
    }

    public static int recursion(int n) {
        if (n > 1) {
            return n * recursion(n - 1);
        }
        return 1;
    }

}
