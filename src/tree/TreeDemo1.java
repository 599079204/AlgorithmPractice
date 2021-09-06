package tree;

import base.MyTreeNode;
import base.Provider;

import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树练习
 */
public class TreeDemo1 {

    public static void main(String[] args) {
        MyTreeNode node = Provider.sequenceTreeNode(12);
        printTree(node, 1);
        System.out.println();
        backorderTree(node);
    }

    /**
     * 前序打印树, 头节点 ==> 左节点 ==> 右节点
     * 指导思想: 先将头节点入栈, 然后弹出并打印栈节点, 有右节点入栈右节点, 有左节点入栈左节点
     */
    private static void preorderTree(MyTreeNode head) {
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(head);
        MyTreeNode curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(curr.val + ", ");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    /**
     * 中序打印树, 左节点 ==> 头节点 ==> 右节点
     * 指导思想: 先让树的左边全部入栈, 然后弹出并打印栈节点, 然后来到弹出节点的右节点
     */
    private static void midOrderTree(MyTreeNode head) {
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode curr = head;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + ", ");
                curr = curr.right;
            }
        }
    }

    /**
     * 后续打印树, 左节点 ==> 右节点 ==> 头节点
     * 指导思想: 循环体内逻辑: 每次都peek栈内节点, 首次递归序时左子节点入栈, 第二次右子节点入栈, 最后弹出节点并打印
     */
    private static void backorderTree(MyTreeNode head) {
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(head);
        MyTreeNode curr, lastPop = head;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (curr.left != null && curr.left != lastPop && curr.right != lastPop) {
                // 第一次递归序: 左子节点入栈
                stack.push(curr.left);
            } else if (curr.right != null && curr.right != lastPop) {
                // 第二次递归序: 右子节点入栈
                stack.push(curr.right);
            } else {
                // 第三次递归序: 弹栈并打印
                lastPop = stack.pop();
                System.out.print(lastPop.val + ", ");
            }
        }
    }

    /**
     * 宽度优先遍历打印树
     */
    private static void widthPrint(MyTreeNode head) {
        // TODO 代码区
    }

    /**
     * 求树的最大宽度
     */
    private static int treeMaxWidth(MyTreeNode head) {
        // TODO 代码区
        return -1;
    }

    /**
     * 前序序列化树
     */
    private static void serialTreePreOrder(MyTreeNode head) {
        // TODO 代码区
    }

    /**
     * 反序列化前序树
     */
    private static MyTreeNode deSerialTreePreOrder(Queue serial) {
        // TODO 代码区
        return null;
    }

    /**
     * 中序序列化树
     */
    private static void serialTreeMidOrder(MyTreeNode head) {
        // TODO 代码区
    }

    /**
     * 反序列化中序树
     */
    private static MyTreeNode deSerialTreeMidOrder(Queue serial) {
        // TODO 代码区
        return null;
    }

    /**
     * 后序序列化树
     */
    private static void serialTreeBackOrder(MyTreeNode head) {
        // TODO 代码区
    }

    /**
     * 反序列化后序树
     */
    private static MyTreeNode deSerialTreeBackOrder(Queue serial) {
        // TODO 代码区
        return null;
    }

    /**
     * 宽度遍历序列化树
     */
    private static void serialWidthTree(MyTreeNode head) {
        // TODO 代码区
    }

    /**
     * 反序列化宽度遍历树
     */
    private static MyTreeNode deSerialWidthTree(Queue serial) {
        // TODO 代码区
        return null;
    }

    /**
     * 递归打印树. 负数: 前序打印; 0: 中序打印; 正数: 后续打印
     */
    private static void printTree(MyTreeNode head, int order) {
        if (head == null) return;
        if (order < 0) System.out.print(head.val + ", ");
        printTree(head.left, order);
        if (order == 0) System.out.print(head.val + ", ");
        printTree(head.right, order);
        if (order > 0) System.out.print(head.val + ", ");
    }
}
