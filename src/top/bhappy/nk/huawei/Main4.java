package top.bhappy.nk.huawei;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int len = str.length();
            if (len == 0) {
                continue;
            }
            int n1 = len / 8;
            int n2 = len % 8;
            for (int i = 0; i < n1; i++) {
                System.out.println(str.substring(i * 8, i * 8 + 7));
            }
            if (n2 != 0) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 8 - n2; i++) {
                    sb.append("0");
                }
                System.out.println(str.substring(n1 * 8) + sb.toString());
            }

        }
    }
}