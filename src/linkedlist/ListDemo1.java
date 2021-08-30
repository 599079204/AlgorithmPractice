package linkedlist;

import base.ListNode;
import base.Provider;

import java.util.Stack;

/**
 * 单链表常见问题练习
 */
public class ListDemo1 {

    public static void main(String[] args) {
        ListNode head = Provider.listNodes(10, 10, 100);
        System.out.println(print(head));
        System.out.println(print(reversalPart(head, 5, 9)));
    }

    /**
     * 反转链表, 遍历法
     */
    private static ListNode reversal(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 反转链表, 递归法
     */
    private static ListNode reversalRecursion(ListNode head) {
        if (head == null) return null;
        return reversalRecursionImpl(null, head);
    }

    /**
     * 反转链表的递归实现
     */
    private static ListNode reversalRecursionImpl(ListNode pre, ListNode curr) {
        if (curr.next == null) {
            curr.next = pre;
            return curr;
        }
        ListNode result = reversalRecursionImpl(curr, curr.next);
        curr.next = pre;
        return result;
    }

    /**
     * 反转部分链表, 遍历法
     */
    private static ListNode reversalPart(ListNode head, int start, int end) {
        if (head == null) return null;
        if (start < 0 || end <= start) return head;
        // 1.校验下标是否正确, 若正确则创建需要节点
        ListNode startPre = null, startNode = null, endNode = null, endNext = null;
        ListNode curr = head;
        int index = 0;
        while (index <= end) {
            if (curr == null) return null;
            if (index == start - 1) startPre = curr;
            if (index == start) startNode = curr;
            if (index == end) {
                endNode = curr;
                endNext = endNode.next;
            }
            curr = curr.next;
            index++;
        }
        // 2.反转指定范围内链表
        ListNode pre = null, next;
        curr = startNode;
        boolean isOver = false;
        while (!isOver) {
            if (curr == endNode) isOver = true;
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 3.接上反转后的链表
        if (startNode != null) startNode.next = endNext;
        if (startPre != null) startPre.next = pre;
        return start == 0 ? pre : head;
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
    private static ListNode calcRingNode(ListNode head) {
        // TODO 代码区
        return null;
    }

    /**
     * 计算出两个无环链表的相交节点
     */
    private static ListNode calcNoRingNode(ListNode head1, ListNode head2) {
        // TODO 代码区
        return null;
    }

    /**
     * 计算出两个有环链表的相交节点
     */
    private static ListNode calcRingNode(ListNode head1, ListNode head2) {
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

    /**
     * 检测链表是否翻转成功
     */
    private static boolean isReversalSuccess(ListNode ori, ListNode target) {
        Stack<Integer> stack = new Stack<>();
        while (target != null) {
            stack.push(target.val);
            target = target.next;
        }
        while (ori != null) {
            if (stack.isEmpty()) return false;
            if (ori.val != stack.pop()) return false;
            ori = ori.next;
        }
        return stack.isEmpty();
    }
}
