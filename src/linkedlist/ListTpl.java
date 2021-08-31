package linkedlist;

import base.ListNode;
import base.Provider;

/**
 * 单链表常见问题模板
 */
public class ListTpl {

    public static void main(String[] args) {
        ListNode head = Provider.listNodes(15, 10, 100);
        System.out.println(print(head));
    }

    /**
     * 反转链表, 遍历法
     */
    private static ListNode reversal(ListNode head) {
        // TODO 代码区
        return null;
    }

    /**
     * 反转链表, 递归法
     */
    private static ListNode reversalRecursion(ListNode head) {
        // TODO 代码区
        return null;
    }

    /**
     * 反转部分链表, 遍历法
     */
    private static ListNode reversalPart(ListNode head, int start, int end) {
        // TODO 代码区
        return null;
    }

    /**
     * 反转部分链表, 递归法
     */
    private static ListNode reversalRecursionPart(ListNode head, int start, int end) {
        // TODO 代码区
        return null;
    }

    /**
     * 找链表中点: 奇数长度返回中点, 偶数长度返回中点中的前一个节点
     */
    private static ListNode midOrPre(ListNode head) {
        // TODO 代码区
        return null;
    }

    /**
     * 找链表中点: 奇数长度返回中点, 偶数长度返回中点中的后一个节点
     */
    private static ListNode midOrBack(ListNode head) {
        // TODO 代码区
        return null;
    }

    /**
     * 判断链表是否为回文
     */
    private static boolean isPalindrome(ListNode head) {
        // TODO 代码区
        return false;
    }

    /**
     * 将链表中小于pivot的数放在左边, 等于的放中间, 大于的放右边. 要求: 稳定
     */
    private static ListNode listPartition(ListNode head, int pivot) {
        // TODO 代码区
        return null;
    }

    /**
     * 给定两个可能无环, 可能有环的单链表h1, h2. 如果两个链表相交则返回相交的第一个节点, 否则返回null
     */
    private static ListNode firstNode(ListNode head1, ListNode head2) {
        // TODO 代码区
        return null;
    }

    /**
     * 求出链表的入环节点, 没有环则返回null
     */
    private static ListNode calcRingEnterNode(ListNode head) {
        // TODO 代码区
        return null;
    }

    /**
     * 计算出两个无环链表的相交节点
     */
    private static ListNode calcNoRingMeetNode(ListNode head1, ListNode head2) {
        // TODO 代码区
        return null;
    }

    /**
     * 计算出两个有环链表的相交节点
     */
    private static ListNode calcRingMeetNode(ListNode head1, ListNode head2) {
        // TODO 代码区
        return null;
    }

    /**
     * 删除链表上, 所有值为 'value' 的节点
     */
    private static ListNode removeValueNode(ListNode head, int value) {
        // TODO 代码区
        return null;
    }

    /**
     * 普通链表打印
     */
    private static String print(ListNode head) {
        if (head == null) return "null";
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        return sb.toString();
    }
}
