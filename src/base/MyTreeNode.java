package base;

/**
 * 自定义树节点
 */
public class MyTreeNode {

    public int val;

    public MyTreeNode left;

    public MyTreeNode right;

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
