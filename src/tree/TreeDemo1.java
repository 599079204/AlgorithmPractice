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
        MyTreeNode node = Provider.sequenceTreeNode(6);
        printTree(node, 1);
        System.out.println();
        backorderTree(node);
    }

    /**
     * 前序打印树, 头节点 ==> 左节点 ==> 右节点
     * 指导思想: 先将头节点入栈, 然后弹出并打印栈节点, 有右节点入栈右节点, 有左节点入栈左节点
     */
    private static void preorderTree(MyTreeNode head) {
        StringBuilder sb = new StringBuilder();
        Stack<MyTreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            sb.append(head.val).append(", ");
            if (head.right != null) stack.push(head.right);
            if (head.left != null) stack.push(head.left);
        }
        System.out.println(sb.toString());
    }

    /**
     * 中序打印树, 左节点 ==> 头节点 ==> 右节点
     * 指导思想: 先让树的左边全部入栈, 然后弹出并打印栈节点, 然后来到弹出节点的右节点
     */
    private static void midOrderTree(MyTreeNode head) {
        StringBuilder sb = new StringBuilder();
        Stack<MyTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                sb.append(head.val).append(", ");
                head = head.right;
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 后续打印树, 左节点 ==> 右节点 ==> 头节点
     * 指导思想: 先将头节点入栈,
     */
    private static void backorderTree(MyTreeNode head) {
        StringBuilder sb = new StringBuilder();
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(head);
        MyTreeNode curr, lastPop = null;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (curr.left != null && curr.left != lastPop && curr.right != lastPop) {
                stack.push(curr.left);
            } else if (curr.right != null && curr.right != lastPop) {
                stack.push(curr.right);
            } else {
                lastPop = stack.pop();
                sb.append(lastPop.val).append(", ");
            }
        }
        System.out.println(sb.toString());
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
