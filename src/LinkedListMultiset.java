import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
    // The first node (HEAD)
    private Node<T> firstNode = null;

    // The current node
    private Node<T> currentNode = null;

    // The last node (TAIL)
    private Node<T> lastNode = null;

	public LinkedListMultiset() {
		// Implement me!
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		
		// default return, please override when you implement this method
		return 0;
	} // end of search()
	
	
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset

// LinkedList Nodes
class Node<T>
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
