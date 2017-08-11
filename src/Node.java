// LinkedList Nodes
public class Node<T extends Comparable<T>>
{
    // Previous node
    private Node<T> PreviousNode;

    // Next node
    private Node<T> NextNode;

    // The item in this current node
    private T item;

    // Instance count of this item
    private int instanceCount;


    // Constructor
    public Node(T item, Node<T> previousNode, Node<T> nextNode, int instanceCount)
    {
        this.item = item;
        this.setPreviousNode(previousNode);
        this.setNextNode(nextNode);
        this.instanceCount = instanceCount;
    }

    public Node(T item) { this.item = item; }

    // Getters and setters lol...
    public Node<T> getPreviousNode()
    {
        return PreviousNode;
    }

    public void setPreviousNode(Node<T> previousNode)
    {
        PreviousNode = previousNode;
    }

    public Node<T> getNextNode()
    {
        return NextNode;
    }

    public void setNextNode(Node<T> nextNode)
    {
        NextNode = nextNode;
    }

    public T getItem()
    {
        return item;
    }

    public void setItem(T item)
    {
        this.item = item;
    }

    public void setInstanceCount(int instanceCount)
    {
        this.instanceCount = instanceCount;
    }

    public int getInstanceCount()
    {
        return instanceCount;
    }

}
