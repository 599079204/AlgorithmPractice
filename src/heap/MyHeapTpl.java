package heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 堆结构模板. 包括: 大根堆, 小根堆
 */
public class MyHeapTpl {

    // 堆实际长度
    private int size;

    // 堆长度限制
    private int limit;

    // 堆数据结构
    // 杀意3，御剑3，剑心通明，击字诀，崩字诀，刺字诀，点字诀，化字诀，神御剑，极剑1，极剑2，我剑2，罡煞合流3，
    // 元始之胎，谷神大法，庚金元神12，甲木元神12，壬水元神12，丙火元神12，戊土元神12，浊之躯，护体血罡，
    // 天枢诀，天璇诀，天玑诀，玉衡诀，开阳诀，摇光诀，北斗绝式12，辟邪政法，太虚元罡，太虚神盾，瞬霎诀，
    // 渊狱诀，幽狱诀，厚德篇，虚空谒神法，坏灭诀，一剑，结云经，天真论，无极妙录，六九两仪，玄天阴阳，
    // 虚极剑，归道剑，为道，观复，无离真法，阴阳化御
    private int[] data;

    public MyHeapTpl(int limit) {
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
        MyHeapTpl bigHeap = new MyHeapTpl(array.length);
        MyHeapTpl lessHeap = new MyHeapTpl(array.length);
        PriorityQueue<Integer> sBigHeap = systemHeap1();
        PriorityQueue<Integer> sLessHeap = systemHeap2();
        // TODO 测试代码区
    }

    // **************************************************** 大根堆 ****************************************************

    /**
     * 添加元素
     */
    public void push1(int value) {
        // TODO 代码区
    }

    /**
     * 弹出元素
     */
    public int pop1() {
        // TODO 代码区
        return -1;
    }

    /**
     * 指定节点自底向上寻找到合适的位置, 以满足大根堆结构
     */
    private void heapInsert1(int insertIndex) {
        // TODO 代码区
    }

    /**
     * 根节点自顶向下寻找到合适的位置, 以满足大根堆结构
     */
    private void heapIfy1(int insertIndex) {
        // TODO 代码区
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
