package top.bhappy.nk.huawei;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet();
        List<Integer> list = new ArrayList();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            set.add(sc.nextLine());
        }
        for (String s : set) {
            list.add(Integer.parseInt(s));
        }
        list.sort(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        });
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
