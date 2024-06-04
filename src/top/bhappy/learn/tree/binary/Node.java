package top.bhappy.learn.tree.binary;

/**
 * @Author: liu lei
 * @Date: 2019/11/22 14:45
 * @Description:
 */

public class Node {

    public int data;

    public Node left;

    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
