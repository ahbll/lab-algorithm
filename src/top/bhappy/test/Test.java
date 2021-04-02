package top.bhappy.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: liu lei
 * @Date: 2021/3/29 09:24
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> cHashMap = new ConcurrentHashMap<>(32);
        cHashMap.put("a", 1);
        cHashMap.put("b", null);
        System.out.println(cHashMap);

    }

}
