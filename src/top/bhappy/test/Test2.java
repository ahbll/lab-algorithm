package top.bhappy.test;

import java.util.*;

/**
 * @Author: liu lei
 * @Date: 2021/5/8 10:54
 * @Description:
 */
public class Test2 {

    public static  class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        // 3 2 1 4
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(3, node2);
        int[] ints = nextLargerNodes2(node1);
        System.out.println(Arrays.toString(ints));


    }

    public static int[] nextLargerNodes2(ListNode head) {
        // 计算长度
        int len = 0;
        ListNode cur = head;
        Deque<int[]> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (cur != null) {
            // 同步增长list，防止set的时候数组越界
            list.add(0);
            if (stack.isEmpty() || cur.val < stack.peek()[1]) {
                stack.push(new int[]{index, cur.val});
            } else {
                while (!stack.isEmpty() && stack.peek()[1] < cur.val) {
                    int[] tmp = stack.pop();
                    list.set(tmp[0], cur.val);
                }
                stack.push(new int[]{index, cur.val});
            }
            index ++;
            cur = cur.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        return res;

    }


    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<int[]> stack = new ArrayDeque<int[]>();

        ListNode cur = head;
        int idx = -1;
        while (cur != null) {
            ++idx;
            ans.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                ans.set(stack.pop()[1], cur.val);
            }
            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }

        int size = ans.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = ans.get(i);
        }
        return arr;
    }



}
