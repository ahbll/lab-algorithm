package top.bhappy.nk.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < count; i++) {
                Integer index = sc.nextInt();
                int value = sc.nextInt();
                Integer num = map.get(index);
                if (null != num) {
                    num = num + value;
                } else {
                    num = value;
                }
                map.put(index, num);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
