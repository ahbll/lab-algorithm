package top.bhappy.testing.smartx;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liu lei
 * @Date: 2020/7/21 22:48
 * @Description:
 */

//实现统计一篇英文文章内每个单词的出现频率，并返回出现频率最高的前10个单词及其出现次数
public class Test1 {

    public static void main(String[] args) {
        String text = "Life is a journey, not the destination, but the scenery along the should be and the mood at the view." +
                "One needs 3 things to be truly happy living in the world: some thing to do, some one to love, some thing to hope for." +
                "One needs 3 things to be truly happy living in the world: some thing to do, some one to love, some thing to hope for." +
                "Time goes by so fast, people go in and out of your life. You must never miss the opportunity to tell these people how much they mean to you.";
        Map<String, Integer> wordCountMap = getWordCountMap(text);
//        wordCountMap.forEach((key, value) -> {
//            System.out.print(key + "  " + value);
//            System.out.println();
//        });

//        System.out.println("--------------");
        Map<String, Integer> maxTenWordCountMap = getMaxTenWordCountMap(wordCountMap);

        maxTenWordCountMap.forEach((key, value) -> {
            System.out.print(key + "  " + value);
            System.out.println();
        });
    }

    public static Map<String, Integer> getWordCountMap(String text) {
        Map<String, Integer> map = new HashMap();
        int start = 0;
        int end = 0;
        boolean b = false;
        for (int i = 0; i < text.length(); i ++) {
            char c = text.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (!b) {
                    start = i;
                    b = true;
                }
            } else {
                if (b) {
                    end = i;
                    b = false;
                    String word = text.substring(start, end);
                    Integer count = map.get(word);
                    if (count != null) {
                        count ++;
                    } else {
                        count = 1;
                    }
                    map.put(word, count);
                }
            }
        }
        return map;
    }

    //可以用最大堆优化
    public static Map<String, Integer> getMaxTenWordCountMap(Map<String, Integer> rawMap) {
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : rawMap.entrySet()) {
            int size = resultMap.size();
            if (size < 10) {
                resultMap.put(entry.getKey(), entry.getValue());
            } else {
                String minWord = "";
                int minCount = Integer.MAX_VALUE;
                for (Map.Entry<String, Integer> entry2 : resultMap.entrySet()) {
                    if (minCount > entry2.getValue()) {
                        minWord = entry2.getKey();
                        minCount = entry2.getValue();
                    }
                }
                if (entry.getValue() > minCount) {
                    resultMap.remove(minWord);
                    resultMap.put(entry.getKey(), entry.getValue());
                }

            }
        }
        return resultMap;
    }
}
