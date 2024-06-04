package top.bhappy.learn.tree.binary;

import java.util.Stack;

/**
 * @Author: liu lei
 * @Date: 2021/5/19 23:51
 * @Description:
 */
public class TraversalStack {

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


    public static void pre(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (null != node.right) {
                stack.add(node.right);
            }
            if (null != node.left) {
                stack.add(node.left);
            }
        }
    }

    public static void in(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.data + " ");
            if (root.right != null) {
                stack.push(root.right);
                root = root.right;
            }
        }

    }

}
