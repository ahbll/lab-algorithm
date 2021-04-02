package top.bhappy.testing.huawei.v2.m3;

import java.util.*;

/**
 * @Author: liu lei
 * @Date: 2021/3/27 15:51
 * @Description:
 */
public class Test1 {

    /**
     *  pid     1 3 10 5
     *  ppid    3 0 5  3
     *  kill    5
     *  return  5 10
     * @param args
     */
    public static void main(String[] args) {
        int[] pidArr = {1, 3, 10, 5};
        int[] ppidArr = {3, 0, 5, 3};
        int[] kill = kill(pidArr, ppidArr, 5);
        for (int i = 0; i < kill.length; i ++) {
            System.out.print(kill[i] + " ");
        }
    }

    //队列
    public static int[] kill2(int[] pidArr, int[] ppidArr, int pid) {

        return null;
    }


    //递归
    public static int[] kill(int[] pidArr, int[] ppidArr, int pid) {
        Map<String, Object> map = new HashMap<>();
        if (pid == 0) {
            return pidArr;
        }
        recur(pidArr, ppidArr, pid, map);
        Set<String> pids = map.keySet();
        int[] result = new int[pids.size()];
        int i = 0;
        for (String s : pids) {
            result[i] = Integer.parseInt(s);
            i ++;
        }
        return result;
    }

    private static void recur(int[] pidArr, int[] ppidArr, int pid, Map<String, Object> result) {
        result.put(pid + "", null);
        for (int i = 0; i < ppidArr.length; i++) {
            if (ppidArr[i] == pid && !result.containsKey(pidArr[i] + "")) {
                recur(pidArr, ppidArr, pidArr[i], result);
            }
        }
    }
}
