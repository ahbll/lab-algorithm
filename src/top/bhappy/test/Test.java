package top.bhappy.test;


import java.util.ArrayList;

/**
 * @Author: liu lei
 * @Date: 2021/3/3 18:00
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<String> list  = new ArrayList<>();
        list.add("a12");
        list.add("b12");
        list.add("c33");
        list.removeIf(next -> !next.contains("12"));
        for (String s : list) {
            System.out.println(s);
        }

    }

}
