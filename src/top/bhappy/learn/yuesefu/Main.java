package top.bhappy.learn.yuesefu;

/**
 * @Author: liu lei
 * @Date: 2020/4/7 09:53
 * @Description:
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 约瑟夫环是一个数学的应用问题：
 * 已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。
 * 从编号为k的人开始报数，
 * 数到m的那个人出列；
 * 他的下一个人又从1开始报数，数到m的那个人又出列；
 * 依此规律重复下去，直到圆桌周围的人全部出列。
 * 写程序实现上述过程
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        //add，remove， peek
        solve(n, k, m);
        System.out.println();
        solve2(n, k, m);
    }

    public static void solve(int n, int k, int m) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            queue.offer(i + 1);
        }
        for(int i = 0; i < k - 1; i++) {
            queue.offer(queue.poll());
        }
        while(!queue.isEmpty()) {
            for(int i = 0; i < m - 1; i++) {
                queue.offer(queue.poll());
            }
            int a = queue.poll();
            System.out.print(a + " ");
        }
    }

    public static void solve2(int n, int k, int m) {
        //初始化链表
        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i < n + 1; i++) {
            Node node = new Node(i);
            current.next = node;
            current = node;
        }
        current.next = head;
        //找到第k个节点
        current = head;
        for (int i = 2; i < k + 1; i++) {
            current = current.next;
        }
        //报数
        while (current.next != current) {
            //找到报数为m-1的人
            for (int i = 2; i < m; i++) {
               current = current.next;
            }
            //输出报数为m的人的编号
            System.out.print(current.next.value + " ");
            //移除报数为m的人
            current.next = current.next.next;
            //移动current
            current = current.next;
        }
        System.out.print(current.value + " ");
    }


    public static class Node {
        int value;
        Node next;
        public Node (int value) {
            this.value = value;
        }
    }


}
