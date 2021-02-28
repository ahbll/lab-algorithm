package top.bhappy.learn.list.link;

/**
 * @Author: liu lei
 * @Date: 2020/2/27 15:27
 * @Description:
 */

import java.util.Stack;

/**
 * 栈的方式
 */
public class StackReverse {

    public static Node reverse(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        head = stack.pop();
        node = head;
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            node.next = pop;
            node = pop;
        }
        node.next = null;
        return head;

    }
}
