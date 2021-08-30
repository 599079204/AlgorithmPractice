package sort;

import base.Provider;

import java.util.Arrays;

/**
 * 基础排序模板
 */
public class SortTpl {

    // 原始数据及拍完序后的数据
    private static int[] oriData;
    private static int[] sortData;

    public static void main(String[] args) {
        // 生成测试数据
        generate(1_000, 0, 1000);
    }

    /**
     * 选择排序
     */
    private static void selection() {
        long start = System.currentTimeMillis();
        // TODO 代码区
        System.out.println("选择排序耗时: " + (System.currentTimeMillis() - start) + ", 结果: " + check());
    }

    /**
     * 冒泡排序
     */
    private static void bubbling() {
        long start = System.currentTimeMillis();
        // TODO 代码区
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
        // TODO 代码区
        System.out.println("希尔排序耗时: " + (System.currentTimeMillis() - start) + ", 结果: " + check());
    }

    /**
     * 插入, 希尔共用的插入排序逻辑
     */
    private static void insertImpl(int interval) {
        // TODO 代码区
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
        // TODO 代码区
    }

    /**
     * 合并两个有序数组
     */
    private static void merge2Array(int leftStart, int leftEnd, int rightStart, int rightEnd) {
        // TODO 代码区
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
        // TODO 代码区
    }

    /**
     * 荷兰国旗问题
     */
    private static int[] netherLand(int start, int end) {
        // TODO 代码区
        return new int[]{-1, -1};
    }

    /**
     * 计数排序, 要求: 数值范围较小
     */
    private static void countSort() {
        long startTime = System.currentTimeMillis();
        // TODO 代码区
        System.out.println("计数排序耗时: " + (System.currentTimeMillis() - startTime) + ", 结果: " + check());
    }

    /**
     * 基数排序, 要求: 所有数必须都是正数
     */
    private static void baseSort() {
        long startTime = System.currentTimeMillis();
        // TODO 代码区
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
