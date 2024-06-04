package top.bhappy.testing.huawei.prepare;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liu lei
 * @Date: 2020/4/7 00:35
 * @Description:
 */
class Test {

    public static void main(String[] args) {
        List<String> strings = new Test().letterCombinations("");
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println(strings.size());
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }
        String[][] arr = new String[10][];
        arr[2] = new String[]{"a", "b", "c"};
        arr[3] = new String[]{"d", "e", "f"};
        arr[4] = new String[]{"g", "h", "i"};
        arr[5] = new String[]{"j", "k", "l"};
        arr[6] = new String[]{"m", "n", "o"};
        arr[7] = new String[]{"p", "q", "r", "s"};
        arr[8] = new String[]{"t", "u", "v"};
        arr[9] = new String[]{"w", "x", "y", "z"};
        int[] numArr = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            int num = Integer.parseInt(digits.charAt(i) + "");
            numArr[i] = num;
        }
        recur("", arr, numArr, result);
        return result;
    }

    public void recur(String pre, String[][] arr, int[] numArr, List<String> result) {
        if (pre.length() == numArr.length) {
            result.add(pre);
            return;
        }
        for (String s : arr[numArr[pre.length()]]) {
            recur(pre + s, arr, numArr, result);
        }
    }
}