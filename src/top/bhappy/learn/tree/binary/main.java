package top.bhappy.learn.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: liu lei
 * @Date: 2019/11/22 14:46
 * @Description:
 */
public class main {

    public static void main(String[] args) {
        Node rootNode = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        rootNode.left = node1;
        rootNode.right = node2;
        Node node4 = new Node(4);
        node1.right = node4;
        Node node5= new Node(5);
        node2.left = node5;
        depth_ergodic(rootNode);
        System.out.println("-------------");
        scope_ergodic(rootNode);
    }

    public static void depth_ergodic(Node node) {
        Stack<Node> stack = new Stack();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public static void scope_ergodic(Node node) {
        Queue<Node> queue = new LinkedList();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }

    }


}
