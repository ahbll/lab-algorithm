package top.bhappy.testing.baidu;

/**
 * @Author: liu lei
 * @Date: 2020/5/6 17:27
 * @Description:
 */

import java.util.Arrays;

/**给出一棵二叉树的先序和中序数组，通过这两个数组直接生成正确的后序数组。
 *              a
*            b      c
 *         d   e   f  g
 *
 * 前序：a b d e c f g
 * 中序：d b e a f c g
 *
 */
public class BuildTree {

    public static void main(String[] args) {
        Node node = reBuild(new String[]{"a", "b", "d", "e", "c", "f", "g"}, new String[]{"d", "b", "e", "a", "f", "c", "g"});
        subForEach(node);
    }


    public static Node reBuild(String[] pre, String[] mid) {
        if (pre.length == 0) {
            return null;
        }
        Node head = new Node(pre[0]);
        int index = 0;
        for (int i = 0; i < mid.length; i++) {
            if (mid[i].equals(head.value)) {
                index = i;
            }
        }
        head.left = reBuild(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(mid, 0, index));
        head.right = reBuild(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(mid, index + 1, mid.length));
        return head;
    }

    public static void subForEach(Node node) {
        if (null == node) {
            return;
        }
        subForEach(node.left);
        subForEach(node.right);
        System.out.println(node.value);
    }



    public static class Node {

        String value;

        Node left;

        Node right;

        Node(String value) {
            this.value = value;
        }
    }

}
