package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 堆结构练习. 包括: 大根堆, 小根堆
 */
public class MyHeapDemo1 {

    // 堆实际长度
    private int size;

    // 堆长度限制
    private int limit;

    // 堆数据结构
    private int[] data;

    public MyHeapDemo1(int limit) {
        this.limit = limit;
        data = new int[limit];
    }

    public static void main(String[] args) {
        // 数据
        Random random = new Random(22);
        int[] array = new int[16];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(22);
        }
        // 自定义的大根堆, 小根堆; 系统的大根堆, 小根堆
        MyHeapDemo1 bigHeap = new MyHeapDemo1(array.length);
        MyHeapDemo1 lessHeap = new MyHeapDemo1(array.length);
        PriorityQueue<Integer> sBigHeap = systemHeap1();
        PriorityQueue<Integer> sLessHeap = systemHeap2();
        // TODO 测试代码区

        for (int i : array) {
            bigHeap.push1(i);
            sBigHeap.add(i);
        }
        System.out.println("原数据: " + Arrays.toString(array));
        System.out.println("自己的大根堆: " + Arrays.toString(bigHeap.data));
        System.out.println("系统的大根堆: " + Arrays.toString(sBigHeap.toArray()));

        StringBuilder sb1 = new StringBuilder();
        sb1.append("自己的大根堆 pop: ");
        while (!bigHeap.isEmpty()) sb1.append(bigHeap.pop1()).append(", ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("系统的大根堆 pop: ");
        while (!sBigHeap.isEmpty()) sb2.append(sBigHeap.poll()).append(", ");
        System.out.println(sb1);
        System.out.println(sb2);
    }

    // **************************************************** 大根堆 ****************************************************

    /**
     * 添加元素
     */
    public void push1(int value) {
        if (size >= limit) throw new RuntimeException("heap is full!");
        data[size] = value;
        heapInsert1(size++);
    }

    /**
     * 弹出元素
     */
    public int pop1() {
        if (size <= 0) throw new RuntimeException("heap is empty!");
        int popValue = data[0];
        data[0] = data[--size];
        heapIfy1(0);
        return popValue;
    }

    /**
     * 指定节点自底向上寻找到合适的位置, 以满足大根堆结构
     */
    private void heapInsert1(int insertIndex) {
        int currIndex = insertIndex, parentIndex = (currIndex - 1) / 2;
        while (parentIndex >= 0 && data[currIndex] > data[parentIndex]) {
            swap(data, currIndex, parentIndex);
            currIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    /**
     * 根节点自顶向下寻找到合适的位置, 以满足大根堆结构
     */
    private void heapIfy1(int insertIndex) {
        int currIndex = insertIndex, leftIndex, rightIndex, swapIndex;
        while (true) {
            leftIndex = currIndex * 2 + 1;
            rightIndex = leftIndex + 1;
            if (leftIndex >= size) break;
            swapIndex = rightIndex >= size || data[leftIndex] >= data[rightIndex] ? leftIndex : rightIndex;
            if (data[swapIndex] <= data[currIndex]) break;
            swap(data, currIndex, swapIndex);
            currIndex = swapIndex;
        }
    }

    // **************************************************** 小根堆 ****************************************************

    /**
     * 添加元素
     */
    public void push2(int value) {
        // TODO 代码区
    }

    /**
     * 弹出元素
     */
    public int pop2() {
        // TODO 代码区
        return -1;
    }

    /**
     * 指定节点自底向上寻找到合适的位置, 以满足大根堆结构
     */
    private void heapInsert2(int insertIndex) {
        // TODO 代码区
    }

    /**
     * 根节点自顶向下寻找到合适的位置, 以满足大根堆结构
     */
    private void heapIfy2(int insertIndex) {
        // TODO 代码区
    }

    // ***************************************************** 其他 *****************************************************

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * 获取系统的大根堆
     */
    private static PriorityQueue<Integer> systemHeap1() {
        return new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    /**
     * 获取系统的小根堆
     */
    private static PriorityQueue<Integer> systemHeap2() {
        return new PriorityQueue<>();
    }

    /**
     * 交换数组内元素
     */
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
