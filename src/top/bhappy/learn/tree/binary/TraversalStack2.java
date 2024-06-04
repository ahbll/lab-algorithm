package top.bhappy.learn.tree.binary;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: liu lei
 * @Date: 2024/6/4 20:42
 * @Description:
 */
public class TraversalStack2 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        pre(root);
        System.out.println();
        in(root);
        System.out.println();
        Node root2 = new Node(1, new Node(2, new Node(3, null, null), null), null);
        in(root2);
    }

    private static void pre(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.pollLast();
            System.out.print(node.data + " ");
            // 注意先放左节点
            if (node.right != null) {
                queue.offerLast(node.right);
            }
            if (node.left != null) {
                queue.offerLast(node.left);
            }

        }
    }


    private static void in(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            while (root.left != null) {
                queue.offerLast(root.left);
                root = root.left;
            }
            root = queue.pollLast();
            System.out.print(root.data + " ");
            if (root.right != null) {
                queue.offerLast(root.right);
                root = root.right;
            }
        }



    }



}
