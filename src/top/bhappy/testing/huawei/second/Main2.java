package top.bhappy.testing.huawei.second;

import java.util.*;

//75

/**
 * 输入字符串，只包含大小写字母
 * 统计每个字符的数量，按照数量从大到小排序，数量相同的，小写字母在前面
 * 输入：aaBBCCC
 * 输出：C:3;a:2;B:2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println();
                continue;
            }
            Map<Character, Integer> cMap = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                int count = cMap.get(c) == null ? 0 : cMap.get(c);
                cMap.put(c, count + 1);
            }
            Map<Integer, List<Character>> tMap = new TreeMap<>();
            for (Map.Entry<Character, Integer> entry : cMap.entrySet()) {
                List<Character> list = tMap.get(entry.getValue());
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(entry.getKey());
                tMap.put(entry.getValue(), list);
            }
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<Integer, List<Character>> entry : tMap.entrySet()) {
                int count = entry.getKey();
                List<Character> list = entry.getValue();
                if (list.size() == 1) {
                    append(sb, list.get(0), count);
                } else {
                    list = sort(list);
                    for (Character c : list) {
                        append(sb, c, count);
                    }
                }
            }
            String[] array = sb.toString().split(";");
            for (int i = array.length - 1; i >= 0; i --) {
                System.out.print(array[i]);
                System.out.print(";");
            }
            System.out.println();
        }
    }
    public static void append(StringBuffer sb, char c, int count) {
        sb.append(c + "");
        sb.append(":");
        sb.append(count);
        sb.append(";");
    }


    public static List<Character> sort(List<Character> list) {
        Collections.sort(list);
        List<Character> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= 'a' ) {
                index = i;
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        for (int i = list.size() - 1; i >= index; i--) {
            result.add(list.get(i));
        }

        return result;
    }
}