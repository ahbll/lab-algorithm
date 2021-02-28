package top.bhappy.learn.list.link;

/**
 * @Author: liu lei
 * @Date: 2020/12/23 10:45
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        //testRevert();

        //testCheckRing();

        //testMerge();

        //testRemoveN(3);
        //testRemoveN(10);

        testFindM();

    }

    public static void testRevert() {
        LinkedList lList = new LinkedList();
        lList.add(new Node(0));
        lList.add(new Node(1));
        lList.add(new Node(2));
        lList.add(new Node(3));
        lList.add(new Node(4));
        lList.add(new Node(5));
        lList.print();
        lList.revert();
        System.out.println("-------");
        lList.print();
    }

    public static void testCheckRing() {
        LinkedList lList = new LinkedList();
        lList.add(new Node(0));
        lList.add(new Node(1));
        lList.add(new Node(2));
        System.out.println(lList.checkRing());
        System.out.println("-------");
        Node node = new Node(3);
        lList.add(node);
        lList.add(new Node(4));
        lList.add(node);
        System.out.println(lList.checkRing());
    }

    public static void testMerge() {
        LinkedList l1 = new LinkedList();
        l1.add(new Node(0));
        l1.add(new Node(2));
        l1.add(new Node(3));

        LinkedList l2 = new LinkedList();
        l2.add(new Node(1));
        l2.add(new Node(3));
        l2.add(new Node(4));

        LinkedList mergeList = LinkedList.merge(l1, l2);
        mergeList.print();
    }

    public static void testRemoveN(int n) {
        LinkedList lList = new LinkedList();
        lList.add(new Node(0));
        lList.add(new Node(1));
        lList.add(new Node(2));
        lList.add(new Node(3));
        lList.add(new Node(4));
        lList.add(new Node(5));
        System.out.println(lList.removeN(n));
        lList.print();
    }

    public static void testFindM() {
        LinkedList lList = new LinkedList();
        lList.add(new Node(0));
        lList.add(new Node(1));
        lList.add(new Node(2));
        lList.add(new Node(3));
        lList.add(new Node(4));
        lList.add(new Node(5));
        System.out.println(lList.findM().value);
        lList.add(new Node(6));
        System.out.println(lList.findM().value);
    }


}
