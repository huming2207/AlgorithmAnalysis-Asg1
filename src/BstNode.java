//Node for Binary Search Tree
public class BstNode<T extends Comparable<T>>
{
    //Left Node in BST
    private BstNode<T> LeftNode;

    //Right Node in BST
    private BstNode<T> RightNode;

    //element stored in the Node
    private T item;

    //record the number of instance
    private int instanceCount;

    public BstNode(T item, int instanceCount, BstNode<T> LeftNode, BstNode<T> RightNode)
    {
        this.setLeftNode(LeftNode);
        this.setRightNode(RightNode);
        this.item = item;
        this.instanceCount = instanceCount;
    }

    public BstNode(T item) {this.item = item;}

    public BstNode<T> getLeftNode()
    {
        return LeftNode;
    }

    public void setLeftNode(BstNode<T> leftNode)
    {
        LeftNode = leftNode;
    }

    public BstNode<T> getRightNode()
    {
        return RightNode;
    }

    public void setRightNode(BstNode<T> rightNode)
    {
        RightNode = rightNode;
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