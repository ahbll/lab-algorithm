package top.bhappy.learn.tree.binary;


/**
 * @Author: liu lei
 * @Date: 2021/2/22 21:47
 * @Description:
 */
public class BinarySearchTree {

    //        5
    //    2       6
    //   1  3       8
    //  0    4        9
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        //insert
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(0);
        tree.insert(4);

        tree.printMid();
        //find
        Node node1 = tree.find(7);
        if (node1 != null) {
            System.out.println(node1.data);
        } else {
            System.out.println("null");
        }
        Node node2 = tree.find(6);
        if (node2 != null) {
            System.out.println(node2.data);
        } else {
            System.out.println("null");
        }
        //delete
//        tree.delete(100);
//        tree.printMid();
        tree.delete(9);
        tree.printMid();
        tree.delete(6);
        tree.printMid();
        tree.delete(2);
        tree.printMid();


    }

    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (p.data < data) {
                p = p.right;
            } else if (p.data > data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (p.data < data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                } else {
                    p = p.right;
                }
            } else if (p.data > data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                } else {
                    p = p.left;
                }
            } else {
                System.out.println("节点已存在，插入失败");
            }
        }

    }

    public void delete(int data) {
        Node p = tree;
        // p的父节点
        Node pp = null;
        while (p != null) {
            if (p.data < data) {
                pp = p;
                p = p.right;
            } else if (p.data > data) {
                pp = p;
                p = p.left;
            } else {
                //左子树为空，右子树不为空
                if (p.left == null && p.right != null) {
                    if (pp.left == p) {
                        pp.left = p.right;
                    } else {
                        pp.right = p.right;
                    }
                    return;
                    //右子树为空，左子树不为空
                } else if (p.right == null && p.left != null) {
                    if (pp.left == p) {
                        pp.left = p.left;
                    } else {
                        pp.right = p.left;
                    }
                    return;
                    //左子树为空，右子树为空
                } else if (p.left == null && p.right == null) {
                    if (pp.left == p) {
                        pp.left = null;
                    } else {
                        pp.right = null;
                    }
                    return;
                    // 左子树不为空，右子树不为空
                    // todo 有bug！！！！！！！！！！！！！！！！！
                } else {
                    // 寻找右子树最小值
                    Node minP = p.right;
                    Node minPP = p;
                    while (minP.left != null) {
                        minPP = minP;
                        minP = minP.left;
                    }
                    //从二叉树中删掉该最小节点
                    if (minPP.left == minP) {
                        minPP.left = null;
                    } else {
                        minPP.right = null;
                    }
                    //将该最小节点的右子树放到该节点的父节点的左子树上(该最小节点没有左子树)？？？？？？？？？
                    minPP.right = minP.right;
                    //将该最小节点放入要被删除的节点
                    minP.left = p.left;
                    minP.right = p.right;
                    if (pp.left == p) {
                        pp.left = minP;
                    } else {
                        pp.right = minP;
                    }
                    return;
                }
            }
        }
    }

    // 中序遍历
    public void printMid() {
        printMid(tree);
        System.out.println();
    }

    private void printMid(Node node) {
        if (node != null) {
            printMid(node.left);
            System.out.print(node.data + " ");
            printMid(node.right);
        }
    }

    public Node findMin() {

        return null;
    }

    public Node findMax() {

        return null;
    }


}
