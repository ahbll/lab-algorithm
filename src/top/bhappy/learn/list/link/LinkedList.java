package top.bhappy.learn.list.link;

/**
 * @Author: liu lei
 * @Date: 2021/2/14 21:31
 * @Description:
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (null == head) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    // 使用头插法逆置链表
    // 0-->1-->2-->3-->4-->5
    public void revert() {
        if (null == head || null == head.next) {
            return;
        }
        Node curr = head;
        Node next = head.next;
        while (next != null) {
            curr.next = next.next;
            next.next = head;
            head = next;
            next = curr.next;
        }
//        tail = head;
//        LNode curr = head;
//        LNode next;
//        while (curr != null) {
//            next = curr.next;
//            curr.next = head;
//            head = curr;
//            curr = next;
//
//        }
//        // 最后一个节点的next置成null！！！！！！！！！！！！！
//        tail.next = null;
        return;
    }

    // 链表中环的检测
    public boolean checkRing() {
        if (head == null || head.next == null) {
            return false;
        }
        Node first = head;
        Node second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }

    // 两个有序的链表合并
    public static LinkedList merge(LinkedList l1, LinkedList l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        LinkedList list = new LinkedList();
        Node curr1 = l1.head;
        Node curr2 = l2.head;
        while (curr1 != null && curr2 != null) {
            if (curr1.value <= curr2.value) {
                list.add(curr1);
                curr1 = curr1.next;
            } else {
                list.add(curr2);
                curr2 = curr2.next;
            }
        }
        Node curr = null;
        if (curr1 != null) {
            curr = curr1;
        }
        if (curr2 != null) {
            curr = curr2;
        }
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        return list;
    }

    // 删除链表倒数第n个结点
    // 1 2 3 4 5
    public boolean removeN(int n) {
        if (head == null) {
            return false;
        }
        Node p1 = head;
        Node p2 = head;
        while (n > 0) {
            if (p1 != null) {
                p1 = p1.next;
                n--;
            } else {
                return false;
            }
        }
        if (p1 == null) {
            head = head.next;
            return true;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return true;
    }


    //求链表的中间结点
    public Node findM() {
        if (null == head) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

}
