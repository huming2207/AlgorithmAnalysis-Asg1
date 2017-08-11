//Node for Binary Search Tree
public class BstNode<T extends Comparable<T>>
{
    //Left Node in BST
    private BstNode<T> leftNode;

    //Right Node in BST
    private BstNode<T> rightNode;

    //element stored in the Node
    private T item;

    //record the number of instance
    private int instanceCount;

    public BstNode(T item, int instanceCount, BstNode<T> leftNode, BstNode<T> rightNode)
    {
        this.setLeftNode(leftNode);
        this.setRightNode(rightNode);
        this.item = item;
        this.instanceCount = instanceCount;
    }

    public BstNode(T item) {this.item = item;}

    public BstNode<T> getLeftNode()
    {
        return leftNode;
    }

    public void setLeftNode(BstNode<T> leftNode)
    {
        this.leftNode = leftNode;
    }

    public BstNode<T> getRightNode()
    {
        return rightNode;
    }

    public void setRightNode(BstNode<T> rightNode)
    {
        this.rightNode = rightNode;
    }

    public T getItme()
    {
        return item;
    }

    public void setItem(T item)
    {
        this.item = item;
    }

    public int getInstanceCount()
    {
        return instanceCount;
    }

    public void setInstanceCount(int instanceCount)
    {
        this.instanceCount = instanceCount;
    }

}