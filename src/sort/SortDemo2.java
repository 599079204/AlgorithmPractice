package sort;

import base.Provider;

import java.util.Arrays;
import java.util.Random;

/**
 * 基础排序模板
 */
public class SortDemo2 {

    // 原始数据及拍完序后的数据
    private static int[] oriData;
    private static int[] sortData;

    public static void main(String[] args) {
        // 生成测试数据
        generate(1_000_000, 0, 1000);
        countSort();
    }

    /**
     * 选择排序
     */
    private static void selection() {
        long start = System.currentTimeMillis();
        int minValueIndex;
        for (int i = 0; i < oriData.length - 1; i++) {
            minValueIndex = i;
            for (int j = i + 1; j < oriData.length; j++) {
                if (oriData[j] < oriData[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            if (i != minValueIndex) {
                swap(oriData, i, minValueIndex);
            }
        }
        System.out.println("选择排序耗时: " + (System.currentTimeMillis() - start) + ", 结果: " + check());
    }

    /**
     * 冒泡排序
     */
    private static void bubbling() {
        long start = System.currentTimeMillis();
        boolean isSwap;
        for (int i = 0; i < oriData.length - 1; i++) {
            isSwap = false;
            for (int j = 0; j < oriData.length - i - 1; j++) {
                if (oriData[j + 1] < oriData[j]) {
                    isSwap = true;
                    swap(oriData, j, j + 1);
                }
            }
            if (!isSwap) break;
        }
        System.out.println("冒泡排序耗时: " + (System.currentTimeMillis() - start) + ", 结果: " + check());
    }

    /**
     * 插入排序
     */
    private static void insert() {
        long start = System.currentTimeMillis();
        insertImpl(1);
        System.out.println("插入排序耗时: " + (System.currentTimeMillis() - start) + ", 结果: " + check());
    }

    /**
     * 希尔排序
     */
    private static void shell() {
        long start = System.currentTimeMillis();
        int interval = Math.max(1, (oriData.length - 1) / 3);
        while (interval >= 1) {
            insertImpl(interval);
            interval = interval == 1 ? 0 : Math.max(1, (interval - 1) / 3);
        }
        System.out.println("希尔排序耗时: " + (System.currentTimeMillis() - start) + ", 结果: " + check());
    }

    /**
     * 插入, 希尔共用的插入排序逻辑
     */
    private static void insertImpl(int interval) {
        int insertValue, insertPos;
        for (int i = interval; i < oriData.length; i += interval) {
            insertValue = oriData[i];
            insertPos = i - interval;
            while (insertPos >= 0 && insertValue < oriData[insertPos]) {
                oriData[insertPos + interval] = oriData[insertPos];
                insertPos -= interval;
            }
            oriData[insertPos + interval] = insertValue;
        }
    }

    /**
     * 归并排序
     */
    private static void merge() {
        long startTime = System.currentTimeMillis();
        mergeImpl(0, oriData.length - 1);
        System.out.println("归并排序耗时: " + (System.currentTimeMillis() - startTime) + ", 结果: " + check());
    }

    /**
     * 将数组拆成两部分, 分别对两部分进行排序, 排序完成后再合并两部分的排序
     */
    private static void mergeImpl(int start, int end) {
        if (end <= start) return;
        int mid = start + (end - start) / 2;
        mergeImpl(start, mid);
        mergeImpl(mid + 1, end);
        merge2Array(start, mid, mid + 1, end);
    }

    /**
     * 合并两个有序数组
     */
    private static void merge2Array(int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int[] temp = new int[rightEnd - leftStart + 1];
        int currIndex = 0, leftIndex = leftStart, rightIndex = rightStart;
        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            temp[currIndex++] = oriData[leftIndex] <= oriData[rightIndex] ? oriData[leftIndex++] : oriData[rightIndex++];
        }
        while (leftIndex <= leftEnd) {
            temp[currIndex++] = oriData[leftIndex++];
        }
        while (rightIndex <= rightEnd) {
            temp[currIndex++] = oriData[rightIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            oriData[i + leftStart] = temp[i];
        }
    }

    /**
     * 随机快排
     */
    private static void quick() {
        long startTime = System.currentTimeMillis();
        quickImpl(0, oriData.length - 1);
        System.out.println("快速排序耗时: " + (System.currentTimeMillis() - startTime) + ", 结果: " + check());
    }

    /**
     * 递归调用荷兰国旗
     */
    private static void quickImpl(int start, int end) {
        if (end <= start) return;
        int[] range = netherLand(start, end);
        quickImpl(start, range[0]);
        quickImpl(range[1], end);
    }

    /**
     * 荷兰国旗问题
     */
    private static int[] netherLand(int start, int end) {
        int lessIndex = start - 1, greaterIndex = end + 1, currIndex = start;
        int pivot = oriData[new Random(22).nextInt(end - start + 1) + start];
        while (currIndex < greaterIndex) {
            if (oriData[currIndex] < pivot) {
                swap(oriData, ++lessIndex, currIndex++);
            } else if (oriData[currIndex] == pivot) {
                currIndex++;
            } else {
                swap(oriData, --greaterIndex, currIndex);
            }
        }
        return new int[]{lessIndex, greaterIndex};
    }

    /**
     * 计数排序, 要求: 数值范围较小
     */
    private static void countSort() {
        long startTime = System.currentTimeMillis();
        int maxValue = oriData[0], minValue = oriData[0];
        for (int i = 1; i < oriData.length; i++) {
            maxValue = Math.max(maxValue, oriData[i]);
            minValue = Math.min(minValue, oriData[i]);
        }
        int[] temp = new int[maxValue - minValue + 1];
        for (int i = 0; i < oriData.length; i++) {
            temp[oriData[i] - minValue]++;
        }
        for (int i = 0, index = 0; i < temp.length; i++) {
            for (int j = temp[i], value = minValue + i; j > 0; j--) {
                oriData[index++] = value;
            }
        }
        System.out.println("计数排序耗时: " + (System.currentTimeMillis() - startTime) + ", 结果: " + check());
    }

    /**
     * 基数排序, 要求: 所有数必须都是正数
     */
    private static void baseSort() {
        long startTime = System.currentTimeMillis();
        int maxValue = oriData[0];
        // 找出最大的值
        for (int i = 0; i < oriData.length; i++) {
            maxValue = Math.max(maxValue, oriData[i]);
        }
        // 找出最大值的位数
        int maxDigit = 1;
        while (maxValue > 0) {
            maxDigit++;
            maxValue = maxValue / 10;
        }

        System.out.println("基数排序耗时: " + (System.currentTimeMillis() - startTime) + ", 结果: " + check());
    }

    /**
     * 生成测试数据并排序
     */
    private static void generate(int size, int min, int max) {
        oriData = Provider.intArray(size, min, max);
        sortData = Arrays.copyOf(oriData, oriData.length);
        Arrays.sort(sortData);
    }

    /**
     * 检测排序是否正确
     */
    public static boolean check() {
        for (int i = 0, length = oriData.length; i < length; i++) {
            if (oriData[i] != sortData[i]) return false;
        }
        return true;
    }

    /**
     * 交换数组内元素
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
