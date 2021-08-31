package linkedlist;

import base.ListNode;
import base.Provider;

import java.util.Stack;

/**
 * 单链表常见问题练习
 */
public class ListDemo1 {

    public static void main(String[] args) {
//        ListNode head = Provider.listNodes(8, 4, 100);
//        ListNode head2 = Provider.ringNodes(8, 4);
//        ListNode ring1 = calcRingEnterNode(head);
//        ListNode ring2 = calcRingEnterNode(head2);
//        System.out.println("入环节点: " + (ring1 == null ? "null" : ring1.val) + ", " + (ring2 == null ? "null" : ring2.val));

        testCalcRingEnterNode();
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
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 找链表中点: 奇数长度返回中点, 偶数长度返回中点中的后一个节点
     */
    private static ListNode midOrBack(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 判断链表是否为回文
     */
    private static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        // 1.找到链表的前中节点
        ListNode mid = midOrPre(head);
        // 2.反转后半部分链表
        ListNode pre = null, curr = mid.next, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 3.逐个对比每个节点的值是否相等
        ListNode end = pre;
        boolean result = true;
        curr = head;
        while (curr != null && pre != null) {
            if (curr.val != pre.val) {
                result = false;
                break;
            }
            pre = pre.next;
            curr = curr.next;
        }
        // 4.反转后半部分链表(还原)
        pre = null;
        curr = end;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        mid.next = pre;
        return result;
    }

    /**
     * 将链表中小于pivot的数放在左边, 等于的放中间, 大于的放右边. 要求: 稳定
     */
    private static ListNode listPartition(ListNode head, int pivot) {
        // 1.将链表按值大小分成3个链表
        ListNode less = null, lessEnd = null, equal = null, equalEnd = null, greater = null, greaterEnd = null, next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (lessEnd == null) less = head;
                else lessEnd.next = head;
                lessEnd = head;
            } else if (head.val == pivot) {
                if (equalEnd == null) equal = head;
                else equalEnd.next = head;
                equalEnd = head;
            } else {
                if (greaterEnd == null) greater = head;
                else greaterEnd.next = head;
                greaterEnd = head;
            }
            head = next;
        }
        // 2.将3个链表的首尾相连
        if (lessEnd != null) lessEnd.next = equal != null ? equal : greater;
        if (equalEnd != null) equalEnd.next = greater;
        return less != null ? less : equal != null ? equal : greater;
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
        if (head == null || head.next == null || head.next.next == null) return null;
        // 1.通过快慢指针追赶方式确定是否为有环链表
        boolean hasRing = false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasRing = true;
                break;
            }
        }
        // 2.若是有环链表, 通过计步法找出入环节点
        if (hasRing) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }

    /**
     * 测试 '两个无环链表的相交节点' 代码是否正确
     */
    private static void testCalcNoRingMeetNode() {
        // 情况一: 两个无环链表的相交节点位置在 meetIndex 上
        int meetIndex = 5;
        ListNode list1 = Provider.listNodes(16, 1, 99);
        ListNode list2 = Provider.listNodes(4, 1, 99);
        ListNode meetNode = list1;
        for (int i = 0; i < meetIndex; i++) {
            meetNode = meetNode.next;
        }
        ListNode list2End = list2;
        while (list2End.next != null) {
            list2End = list2End.next;
        }
        list2End.next = meetNode;
        System.out.println(print(list1));
        System.out.println(print(list2));
        System.out.println("无环链表的相交节点 (情况一) : " + print(calcNoRingMeetNode(list1, list2)));

        // 情况一: 两个无环链表无相交节点
        ListNode list3 = Provider.listNodes(16, 1, 99);
        ListNode list4 = Provider.listNodes(12, 1, 99);
        System.out.println("无环链表的相交节点 (情况二) : " + print(calcNoRingMeetNode(list3, list4)));
    }

    /**
     * 计算出两个无环链表的相交节点
     */
    private static ListNode calcNoRingMeetNode(ListNode head1, ListNode head2) {
        return calcNoRingMeetNodeImpl(head1, head2, null);
    }

    /**
     * 计算出两个无环链表的相交节点的具体实现
     */
    private static ListNode calcNoRingMeetNodeImpl(ListNode head1, ListNode head2, ListNode end) {
        // 1.找出两个链表的末尾节点, 并算出各自的长度
        int len1 = 1, len2 = 1;
        ListNode curr1 = head1, curr2 = head2;
        while (curr1.next != end) {
            curr1 = curr1.next;
            len1++;
        }
        while (curr2.next != end) {
            curr2 = curr2.next;
            len2++;
        }
        if (curr1 != curr2) return null;
        // 2.长链表先走差值步
        if (len1 > len2) {
            for (int i = 0, len = len1 - len2; i < len; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0, len = len2 - len1; i < len; i++) {
                head2 = head2.next;
            }
        }
        // 3.找出第一个相等的节点
        while (head1 != null && head2 != null) {
            if (head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    private static void testCalcRingEnterNode() {
        // 情况一: 两个有环链表的相交节点不在环上
        int meetIndex = 3;
        ListNode list1 = Provider.ringNodes(16, 6);
        ListNode list2 = list1;
        for (int i = 0; i < meetIndex; i++) {
            list2 = list2.next;
        }
        System.out.println("有环链表的相交节点 (情况一) : " + calcRingEnterNode(list1, list2).val);

        // 情况二: 两个有环链表的相交节点在环上
        // 情况三: 两个有环链表的无相交节点
    }

    /**
     * 计算出两个有环链表的相交节点
     */
    private static ListNode calcRingEnterNode(ListNode head1, ListNode head2) {
        // 1.分别找出两个有环链表的入口节点
        ListNode ringEnter1 = calcRingEnterNode(head1);
        ListNode ringEnter2 = calcRingEnterNode(head2);
        // 2.入口节点不一样, 随意返回一个入口节点即可
        if (ringEnter1 != ringEnter2) return ringEnter1;
        // 3.入口节点一样, 将问题转化为求两个无环链表的相交节点
        return calcNoRingMeetNodeImpl(head1, head2, ringEnter1);
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
