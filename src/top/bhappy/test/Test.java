package top.bhappy.test;


import java.util.*;

/**
 * @Author: liu lei
 * @Date: 2021/5/2 23:22
 * @Description:
 */
public class Test {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{1, 2}, new int[]{1, 2});
        System.out.println(treeNode);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return recurBuild(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode recurBuild(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return node;
        }
        for (int i = inStart; i <= inEnd; i ++) {
            if (inorder[i] == node.val) {
                // 左子树元素个数
                int len = i - inStart;
                node.left = recurBuild(preorder, inorder, preStart + 1, preStart + len, inStart, i - 1);
                node.right = recurBuild(preorder, inorder, preStart + len + 1, preEnd, i + 1, inEnd);
                break;
            }
        }
        return node;
    }

}


