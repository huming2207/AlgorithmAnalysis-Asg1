// LinkedList Nodes
public class Node<T>
{
    // Previous node
    private Node<T> PreviousNode;

    // Next node
    private Node<T> NextNode;

    // The item in this current node
    private T item;

    // Sequence number of this item
    private int itemSeq;

    // Constructor
    public Node(T item)
    {
        this.item = item;
    }

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

    public void setItemSeq(int itemSeq)
    {
        this.itemSeq = itemSeq;
    }

    public int getItemSeq()
    {
        return itemSeq;
    }
}
