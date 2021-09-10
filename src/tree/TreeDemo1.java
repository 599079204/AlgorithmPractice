package tree;

import base.MyTreeNode;
import base.Provider;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树练习
 */
public class TreeDemo1 {

    public static void main(String[] args) {
        MyTreeNode node = Provider.sequenceTreeNode(12);
        preorderTree(node);
        System.out.println();
        serialTreePreOrder(node);
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
        MyTreeNode lastPop = head, curr;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (curr.left != null && curr.left != lastPop && curr.right != lastPop) {
                stack.push(curr.left);
            } else if (curr.right != null && curr.right != lastPop) {
                stack.push(curr.right);
            } else {
                lastPop = stack.pop();
                System.out.print(lastPop.val + ", ");
            }
        }
    }

    /**
     * 宽度优先遍历打印树
     */
    private static void widthPrint(MyTreeNode head) {
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(head);
        MyTreeNode curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            System.out.print(curr.val + ", ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    /**
     * 求树的最大宽度
     */
    private static void treeMaxWidth(MyTreeNode head) {
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(head);
        MyTreeNode curr, currEnd = head, lastEnd = head;
        int currIndex = 1, maxCount = 0, currCount = 0;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            currCount++;
            if (curr.left != null) {
                lastEnd = curr.left;
                queue.add(curr.left);
            }
            if (curr.right != null) {
                lastEnd = curr.right;
                queue.add(curr.right);
            }
            if (curr == currEnd) {
                currEnd = lastEnd;
                System.out.println("第 " + currIndex + " 层有 " + currCount + " 个节点");
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
                currIndex++;
            }
        }
        System.out.println("最大宽度 = " + maxCount);
    }

    /**
     * 前序序列化树
     */
    private static void serialTreePreOrder(MyTreeNode head) {
        Queue<MyTreeNode> serial = new LinkedList();
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(head);
        MyTreeNode curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            serial.add(curr);
            if (curr != null) {
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }

        while (!serial.isEmpty()) {
            curr = serial.poll();
            System.out.print((curr != null ? curr.val : "null") + ", ");
        }
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
