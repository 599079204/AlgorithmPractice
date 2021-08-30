package base;

import java.util.ArrayList;
import java.util.Random;

/**
 * 数据提供器
 */
public class Provider {

    /**
     * 生成一个int数组, 数值是随机的
     */
    public static int[] intArray(int arraySize, int minValue, int maxValue) {
        if (maxValue < minValue) return new int[0];
        int[] result = new int[arraySize];
        Random random = new Random(22);
        int bound = maxValue - minValue + 1;
        for (int i = 0, length = result.length; i < length; i++) {
            result[i] = random.nextInt(bound) + minValue;
        }
        return result;
    }

    /**
     * 生成一个int数组, 个十百千万等的数基本都有
     */
    public static int[] intArray2(int arraySize, int minValue, int maxValue) {
        if (maxValue < minValue) return new int[0];
        int[] result = new int[arraySize];
        Random random = new Random(22);
        int bound = maxValue - minValue + 1;
        for (int i = 0, length = result.length; i < length; i++) {
            result[i] = testDigit(random.nextInt(bound) + minValue, random);
        }
        return result;
    }

    /**
     * 生成指定长度的链表, 数值随机
     */
    public static ListNode listNodes(int size, int minValue, int maxValue) {
        ListNode node = null;
        Random random = new Random(22);
        int bound = maxValue - minValue + 1;
        for (int i = size - 1; i >= 0; i--) {
            node = new ListNode(minValue + random.nextInt(bound), node);
        }
        return node;
    }

    /**
     * 生成指定长度的链表, 数值线性增长
     */
    public static ListNode sequenceNodes(int size) {
        ListNode node = null;
        for (int i = size - 1; i >= 0; i--) {
            node = new ListNode(i + 1, node);
        }
        return node;
    }

    /**
     * 生成回文链表
     */
    public static ListNode palindromeNodes(int size) {
        ListNode node = null;
        int midIndex = (size - 1) / 2;
        for (int i = size - 1; i >= 0; i--) {
            node = new ListNode(i <= midIndex ? i + 1 : size - i, node);
        }
        return node;
    }

    /**
     * 生成环形链表
     */
    public static ListNode ringNodes(int size, int ringIndex) {
        ListNode node = null, lastNode = null, ringEnterNode = null;
        for (int i = size - 1; i >= 0; i--) {
            node = new ListNode(i + 1, node);
            if (i == size - 1) {
                lastNode = node;
            } else if (i == ringIndex) {
                ringEnterNode = node;
            }
        }
        if (lastNode != null) lastNode.next = ringEnterNode;
        return node;
    }

    /**
     * 生成平衡二叉树, 数值线程增长
     */
    public static MyTreeNode sequenceTreeNode(int size) {
        ArrayList<MyTreeNode> data = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            data.add(new MyTreeNode(i + 1, null, null));
        }
        int left, right;
        for (int i = 0; i < size; i++) {
            left = 2 * i + 1;
            right = left + 1;
            if (left < size) data.get(i).left = data.get(left);
            if (right < size) data.get(i).right = data.get(right);
        }
        return data.get(0);
    }

    private static int testDigit(int value, Random random) {
        int v = value, digit = 0;
        while (v > 0) {
            v = v / 10;
            digit++;
        }
        digit = random.nextInt(digit);
        int a = 1;
        while (digit > 0) {
            a *= 10;
            digit--;
        }
        return value / a;
    }
}
