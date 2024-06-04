package top.bhappy.testing.huawei.v2.jishi;


import java.util.*;


// 70
// todo fix
// fixed

/**
 * 输入：a:2,b:3,A:5@b:3,A:3  (全部字符@已用字符)
 * 输出：a:2,A:2   (剩余字符，按照原序输出，值为零的不输出)
 * <p>
 * case : 1  a:2,b:3,A:5@b:1,A:5   a:2,b:2
 * 2  a:2,b:3,A:5@b:3,A:3   a:2,A:2
 * 3  a:2@                  a:2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //为空，直接返回
            if (line.equals("")) {
                System.out.println();
                continue;
            }
            //arr[0]:所有字符，arr[1]:已用字符
            String[] arr = line.split("@");
            if (arr.length == 1) {
                System.out.println(arr[0]);
                continue;
            }
            String[] allArr = arr[0].split(",");
            String[] usedArr = arr[1].split(",");
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
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < allArr.length; i++) {
                char c = allArr[i].charAt(0);
                int count = map1.get(c + "") - (map2.get(c + "") == null ? 0 : map2.get(c + ""));
                if (count > 0) {
                    sb.append(c);
                    sb.append(":");
                    sb.append(count);
                    sb.append(",");
                }
            }
            String outStr = sb.toString();
            if (outStr.length() > 0) {
                outStr = outStr.substring(0, outStr.length() - 1);
            }
            System.out.println(outStr);
        }
    }
}