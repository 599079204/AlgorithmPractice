package tree;

import base.MyTreeNode;
import base.Provider;

import java.util.Queue;

/**
 * 二叉树模板
 */
public class TreeTpl {

    public static void main(String[] args) {
        MyTreeNode node = Provider.sequenceTreeNode(24);
    }

    /**
     * 前序打印树, 头节点 ==> 左节点 ==> 右节点
     */
    private static void preorderTree(MyTreeNode head) {
        // TODO 代码区
    }

    /**
     * 中序打印树, 左节点 ==> 头节点 ==> 右节点
     */
    private static void midOrderTree(MyTreeNode head) {
        // TODO 代码区
    }

    /**
     * 后续打印树, 左节点 ==> 右节点 ==> 头节点
     */
    private static void backorderTree(MyTreeNode head) {
        // TODO 代码区
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
}
