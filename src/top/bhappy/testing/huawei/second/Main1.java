package top.bhappy.testing.huawei.second;


import java.util.*;


// 70
// todo fix

/**
 * 输入：a:2,b:3,A:5@b:3,A:3
 * 输出：a:2,A:2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println();
                continue;
            }
            String[] arr = line.split("@");

            String[] allArr = arr[0].split(",");
            String[] usedArr;
            if (arr.length == 1) {
                System.out.println(line.substring(0, line.length() - 1));
                continue;
            }
            usedArr = arr[1].split(",");
            Map<String, Integer> map1 = new HashMap<>();
            for (String s : allArr) {
                String[] array = s.split(":");
                map1.put(array[0], Integer.parseInt(array[1]));
            }
            Map<String, Integer> map2 = new HashMap<>();
            for (String s : usedArr) {
                String[] array = s.split(":");
                map2.put(array[0], Integer.parseInt(array[1]));
            }
            for (int i = 0; i < allArr.length; i++) {
                char c = allArr[i].charAt(0);
                int count = map1.get(c + "") - (map2.get(c + "") == null ? 0 : map2.get(c + ""));
                if (count > 0) {
                    System.out.print(c);
                    System.out.print(":");
                    System.out.print(count);
                    if (i != allArr.length - 1) {
                        System.out.print(",");
                    }
                }
            }
            System.out.println();
        }
    }
}