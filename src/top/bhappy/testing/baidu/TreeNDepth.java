package top.bhappy.testing.baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liu lei
 * @Date: 2020/5/6 22:23
 * @Description: 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 * 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，
 * 请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 * a
 * b     c
 * d  e   f  g
 */
public class TreeNDepth {
    public static void main(String[] args) {
        Node head = new Node("a");
        Node n1 = new Node("b");
        Node n2 = new Node("c");
        Node n3 = new Node("d");
        Node n4 = new Node("e");
        Node n5 = new Node("f");
        Node n6 = new Node("g");

        head.left = n1;
        head.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        List<Node> depthN = getDepthN(head, 3);
        for (Node node : depthN) {
            System.out.println(node.value);
        }

    }

    public static List<Node> getDepthN(Node head, int n) {
        List<Node> result = new ArrayList<>();
        Queue<NodeWithDepth> queue = new LinkedList();
        NodeWithDepth headWithDepth = new NodeWithDepth(head, 1);
        queue.add(headWithDepth);
        while (!queue.isEmpty()) {
            NodeWithDepth nodeWithDepth = queue.poll();
            Node node = nodeWithDepth.node;
            int depth = nodeWithDepth.depth;
            if (depth < n) {
                if (node.left != null) {
                    queue.add(new NodeWithDepth(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.add(new NodeWithDepth(node.right, depth + 1));
                }
            } else {
                result.add(node);
            }

        }
        return result;
    }


    public static class Node {

        String value;

        Node left;

        Node right;

        public Node(String value) {
            this.value = value;
        }

    }

    public static class NodeWithDepth {

        Node node;

        int depth;

        public NodeWithDepth() {

        }

        public NodeWithDepth(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }


}
