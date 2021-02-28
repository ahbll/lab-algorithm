package top.bhappy.learn.list.link;

/**
 * @Author: liu lei
 * @Date: 2020/2/27 15:27
 * @Description:
 */

/**
 * 指针的方式
 */
public class PointReverse {
    public static Node reverse(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node p3;
        while (null != p2) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        return p1;
    }
}
