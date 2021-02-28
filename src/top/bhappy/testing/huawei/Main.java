package top.bhappy.testing.huawei;

/**
 * @Author: liu lei
 * @Date: 2020/4/7 22:04
 * @Description:
 * 输入一个句子
 * 句子由单词、空格、数字、标点组成
 * 将单词重组，要求
 * 每个单词首字母大写
 * 单词间用一个空格隔开
 * 句子末尾加。
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String res1 = traversal(line);
        System.out.println(res1);
        String res2 = regex(line);
        System.out.println(res2);
    }

    //遍历的方式
    public static String traversal (String line) {
        line = line + "?";
        int start = 0;
        int end = 0;
        boolean b = false;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < line.length(); i ++) {
            char c = line.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (!b) {
                    start = i;
                    b = true;
                }
            } else {
                if (b) {
                    end = i;
                    b = false;
                    list.add(line.substring(start, end));
                }
            }
        }
        String res = "";
        for (String s : list) {
            s = s.toLowerCase();
            res = res + (s.charAt(0) + "").toUpperCase() + s.substring(1) + " ";
        }
        res = res.substring(0, res.length() - 1) + ".";
        return res;
    }
    //正则方式
    public static String regex(String line) {
        String regex = "[^a-zA-Z]+";
        String[] words = line.split(regex);
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            word = word.toLowerCase();
            res.append((word.charAt(0) + "").toUpperCase()).append(word.substring(1)).append(" ");
        }
        return res.substring(0, res.length() - 1) + ".";
    }




}
