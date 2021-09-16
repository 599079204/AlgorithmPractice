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
        MyTreeNode node = Provider.sequenceTreeNode(7);
//        printTree(node, 1);
//        System.out.println();
        serialTreePreOrder(node);
    }

    /**
     * 前序打印树, 头节点 ==> 左节点 ==> 右节点
     * 指导思想: 先将头节点入栈, 然后弹出并打印栈节点, 有右节点入栈右节点, 有左节点入栈左节点
     */
    private static void preorderTree(MyTreeNode head) {
        Stack<MyTreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + ", ");
            if (head.right != null) stack.push(head.right);
            if (head.left != null) stack.push(head.left);
        }
    }

    /**
     * 中序打印树, 左节点 ==> 头节点 ==> 右节点
     * 指导思想: 先让树的左边全部入栈, 然后弹出并打印栈节点, 然后来到弹出节点的右节点
     */
    private static void midOrderTree(MyTreeNode head) {
        Stack<MyTreeNode> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + ", ");
                head = head.right;
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
            // 根据递归序判断是第几次来到当前节点, 进而执行不同逻辑
            // 特殊处理的几种情况:
            // 1.当前节点的左子节点为null, 可以当做其不是第1次递归序, 因为左子节点为null时, 不用执行任何逻辑
            // 2.当前节点的右子节点为null, 可以当做其不是第2次递归序, 因为右子节点为null时, 不用执行任何逻辑
            if (curr.left != null && curr.left != lastPop && curr.right != lastPop) {
                // 第一次来到curr: 让其左子节点入栈
                stack.push(curr.left);
            } else if (curr.right != null && curr.right != lastPop) {
                // 第二次来到curr: 让其右子节点入栈
                stack.push(curr.right);
            } else {
                // 第三次来到curr: 表示curr的左右节点均处理完成, 弹出打印即可
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
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.val + ", ");
            if (head.left != null) queue.add(head.left);
            if (head.right != null) queue.add(head.right);
        }
    }

    /**
     * 求树的最大宽度
     */
    private static void treeMaxWidth(MyTreeNode head) {
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(head);
        MyTreeNode currEnd = head, nextEnd = null, curr;
        int maxWidth = 0, currWidth = 0;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            currWidth++;
            if (curr.left != null) {
                queue.add(curr.left);
                nextEnd = curr.left;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                nextEnd = curr.right;
            }
            if (curr == currEnd) {
                maxWidth = Math.max(maxWidth, currWidth);
                currEnd = nextEnd;
                currWidth = 0;
            }
        }
        System.out.println("最大宽度 = " + maxWidth);
    }

    /**
     * 前序序列化树
     */

    private static void test(Queue<Integer> queue, MyTreeNode head) {

    }

    private static Queue<Integer> serialTreePreOrder(MyTreeNode head) {
        // 递归法实现


        /*// 非递归法实现
        Queue<Integer> serial = new LinkedList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            serial.add(head != null ? head.val : null);
            if (head != null) {
                stack.push(head.right);
                stack.push(head.left);
            }
        }
        while (!serial.isEmpty()) {
            Integer value = serial.poll();
            System.out.print((value != null ? value : "null") + ", ");
        }
        return serial;*/
    }

    /**
     * 反序列化前序树
     */
    private static MyTreeNode deSerialTreePreOrder(Queue<Integer> serial) {
        Integer value = serial.poll();
        if (value == null) return null;
        MyTreeNode node = new MyTreeNode(value);
        node.left = deSerialTreePreOrder(serial);
        node.right = deSerialTreePreOrder(serial);
        return node;
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
