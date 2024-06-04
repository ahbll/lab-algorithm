package top.bhappy.learn.tree.binary;

/**
 * @Author: liu lei
 * @Date: 2024/6/3 19:46
 * @Description:
 */
public class Traversal {

    public static void main(String[] args) {
        Node rootNode = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        rootNode.left = node1;
        rootNode.right = node2;
        node1.right = new Node(4);
        node2.left = new Node(5);
        preTraversal(rootNode);
        System.out.println();
        midTraversal(rootNode);

        System.out.println();
        Node root2 = new Node(1, new Node(2, new Node(3, null, null), null), null);
        midTraversal(root2);

    }

    public static void preTraversal(Node node) {
        if (null == node) {
            return;
        }
        System.out.print(node.data + ", ");
        preTraversal(node.left);
        preTraversal(node.right);
    }

    public static void midTraversal(Node node) {
        if (null == node) {
            return;
        }
        midTraversal(node.left);
        System.out.print(node.data + ", ");
        midTraversal(node.right);
    }


}
