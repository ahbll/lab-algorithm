package top.bhappy.learn.list.link;

/**
 * @Author: liu lei
 * @Date: 2020/12/23 10:02
 * @Description:
 */
public class Node {

    public int value;

    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

}
