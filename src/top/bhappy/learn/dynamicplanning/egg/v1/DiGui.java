package top.bhappy.learn.dynamicplanning.egg.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liu lei
 * @Date: 2020/4/5 23:51
 * @Description:
 */

public class DiGui {
    private static Map<String, Integer> recordMap = new HashMap<>();
    private static int count = 0;

    public static int getMinSteps(int eggNum, int floorNum) {
        if (null != recordMap.get(eggNum + "," + floorNum)) {
            count++;
            return recordMap.get(eggNum + "," + floorNum);
        }
        if (eggNum < 1 || floorNum < 1) {
            return 0;
        }
        if (eggNum == 1) {
            return floorNum;
        }
        int minSteps = floorNum;
        for (int i = 1; i <= floorNum; i++) {
            minSteps = Math.min(minSteps, Math.max(getMinSteps(eggNum - 1, i - 1), getMinSteps(eggNum, floorNum - i)) + 1);
        }
        recordMap.put(eggNum + "," + floorNum, minSteps);
        return minSteps;
    }

    public static int getCount() {
        return count;
    }
}
