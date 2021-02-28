package top.bhappy.learn.list.link;

/**
 * @Author: liu lei
 * @Date: 2020/2/27 17:30
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node node0 = new Node(0, node1);
        Node head = PointReverse.reverse(node0);
        print(head);
        head = StackReverse.reverse(head);
        print(head);

    }

    public static void print(Node node) {
        System.out.println(node.value);
        while (node.next != null) {
            node = node.next;
            System.out.println(node.value);
        }
    }
}
