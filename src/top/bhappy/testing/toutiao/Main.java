package top.bhappy.testing.toutiao;

/**
 * @Author: liu lei
 * @Date: 2020/4/8 17:42
 * @Description: [(' A ', ' B '), ('A', 'C'), ('B', 'D'), ('D', 'A')] 是否有循环依赖
 */

/**
 *
 * [('A', 'B'), ('A', 'C'), ('B', 'D'), ('D', 'A')] 是否有循环依赖
 *
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"a", "b"});
        list.add(new String[]{"a", "c"});
        list.add(new String[]{"b", "d"});
        list.add(new String[]{"c", "d"});
        list.add(new String[]{"d", "a"});
        boolean result = checkGraphCircle(list);
        System.out.println(result);
    }

    public static boolean checkGraphCircle(List<String[]> list) {
        //所有的节点
        Set<String> allSet = new HashSet<>();
        for (String[] arr : list) {
            for (int i = 0; i < 2; i++) {
                allSet.add(arr[i]);
            }
        }
        //后续的节点
        Set<String> subSet = new HashSet<>();
        for (String[] arr : list) {
            subSet.add(arr[1]);
        }
        //如果所有节点都是后续节点，那么肯定有环
        if (allSet.size() == subSet.size()) {
            return true;
        }
        for (String s : subSet) {
            allSet.remove(s);
        }
        //没有前序的头节点
        Set<String> headSet = allSet;
        //图
        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] arr : list) {
            Set<String> subs = graph.get(arr[0]);
            if (subs == null) {
                subs = new HashSet<>();
                subs.add(arr[1]);
                graph.put(arr[0], subs);
            } else {
                subs.add(arr[1]);
            }
        }
        //遍历图，寻找环
        for (String head : headSet) {
            Set<String> set = new HashSet<>();
            set.add(head);
            findCircle(head, graph, set);
        }
        return flag;
    }

    private static boolean flag = false;

    public static void findCircle(String head, Map<String, Set<String>> graph, Set<String> findSet) {
        Set<String> childSet = graph.get(head);
        for (String child : childSet) {
            if (findSet.contains(child)) {
                flag = true;
                return;
            }
            findSet.add(child);
            findCircle(child, graph, findSet);
        }
    }
}
