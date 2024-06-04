package top.bhappy.nk.nc;


/**
 * @Author: liu lei
 * @Date: 2021/4/29 09:24
 * @Description: nk nc2 重排链表
 * https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=188&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * 将给定单链表L：L0->L1->L2->...Ln-1->Ln
 * 重排序为：L0->Ln->L1->Ln-1....
 * 要求原地排序，不改变节点内部的指
 * 例如：对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.
 */
public class NC2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // {1,2,3,4}
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        reorderList(head);
        print(head);

    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void reorderList(ListNode head) {
        //链表长度为 0、1、2
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode curr = head;
        //链表长度
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        //链表中点坐标
        int mid = len / 2 - 1;
        curr = head;
        for (int i = 0; i < mid; i++) {
            curr = curr.next;
        }
        //链表中点
        ListNode midNode = curr.next;
        curr.next = null;
        //翻转后半部分链表
        //  1-->2-->3-->4-->5
        //  |   |   |
        //  n1  n2  n3
        ListNode n1 = midNode;
        ListNode n2 = n1.next;
        ListNode n3;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        midNode.next = null;
        //合并链表
        //L1
        //  1---->2---->3---->4
        //  |     |     |
        // curr1 next1
        //L2
        //  1---->2---->3---->4
        //  |     |     |
        // curr2 next2
        ListNode curr1 = head;
        ListNode curr2 = n1;
        ListNode next1;
        ListNode next2;
        while (curr1.next != null) {
            next1 = curr1.next;
            next2 = curr2.next;
            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
        if (curr2 != null) {
            curr1.next = curr2;
        }
    }

}
