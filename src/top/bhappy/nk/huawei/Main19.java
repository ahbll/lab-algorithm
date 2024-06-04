package top.bhappy.nk.huawei;

/**
 * @Author: liu lei
 * @Date: 2020/4/7 20:15
 * @Description:
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<String, Integer[]> map = new HashMap<>();
            int count = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < count; i++) {
                String s = sc.nextLine();
                if (map.get(s) == null) {
                    Integer[] array = new Integer[2];
                    array[0] = 1;
                    array[1] = i;
                    map.put(s, array);
                } else {
                    Integer[] array = map.get(s);
                    array[0] = array[0] + 1;
                    array[1] = i;
                }
            }
            Map<Integer, String> treeMap = new TreeMap();
            for (Map.Entry<String, Integer[]> entry : map.entrySet()) {
                String key = entry.getKey();
                String[] arr = key.split("\\s+");
                int len = arr[0].length();
                String content = len > 8 ? arr[0].substring(len - 8, len) : arr[0] +
                        " " + arr[1] + " " + entry.getValue()[0];
                treeMap.put(entry.getValue()[1], content);
            }
            int size = treeMap.size();
            int num = 0;
            for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
                if (num >= size - 8) {
                    System.out.println(entry.getValue());
                    num++;
                }
            }
        }
    }
}
