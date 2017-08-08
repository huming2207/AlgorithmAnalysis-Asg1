import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
    // The first node (HEAD)
    private Node<T> firstNode = null;

    // The last node (TAIL)
    private Node<T> lastNode = null;

	public LinkedListMultiset() {
		// Implement me!
		
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
		//create a new node
	    Node<T> newNode = new Node<>(item);
    	newNode.setInstanceCount(updateInstanceCount(item, 1));
    	
	    if(firstNode == null)
	    {
			firstNode = newNode;
			lastNode = newNode;
		}
	    else
	    {
	    	newNode.setPreviousNode(lastNode);
	    	lastNode.setNextNode(newNode);
	    	lastNode = newNode;
	    }
	} // end of add()
	
	private int updateInstanceCount(T item, int update)
	{
		Node<T> nodePointer = firstNode;
		int count = 1;
		while(nodePointer != null)
		{
			if(nodePointer.getItem().equals(item))
			{
				nodePointer.setInstanceCount(nodePointer.getInstanceCount()+update);
				count = nodePointer.getInstanceCount();
			}
		}
		return count;
	}
	
	
	public int search(T item) {
		// Implement me!
		Node<T> nodePointer = searchHelper(item);
		// default return, please override when you implement this method
		return (nodePointer!=null)? nodePointer.getInstanceCount():0;
	} // end of search()
	
	private Node<T> searchHelper(T item)
	{
		Node<T> nodePointer = firstNode;
		while(nodePointer != null)
		{
			if(nodePointer.getItem().equals(item))
			{
				return nodePointer;
			}
			
			nodePointer = nodePointer.getNextNode();
		}
		return null;
	}
	
	private void removeNode(Node<T> node)
	{
		if(firstNode.equals(node) && lastNode.equals(node))
		{
			firstNode = null;
			lastNode = null;
		}
		if(node.getPreviousNode() != null)
		{
			node.getPreviousNode().setNextNode(node.getNextNode());
		}
		else
		{
			firstNode = node.getNextNode();
		}
		if(node.getNextNode() != null)
		{
			node.getNextNode().setPreviousNode(node.getPreviousNode());
		}
		else
		{
			lastNode = node.getPreviousNode();
		}
		node.setItem(null);
	}
	
	public void removeOne(T item) {
		// Implement me!
		Node<T> node = searchHelper(item);
		
		removeNode(node);
        updateInstanceCount(item,-1);
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		Node<T> nodePointer = firstNode;
		while(nodePointer != null)
		{
			if(nodePointer.getItem().equals(item))
			{
				removeNode(nodePointer);
			}
			nodePointer = nodePointer.getNextNode();
		}
	} // end of removeAll()
	
	
	
	public void print(PrintStream out) {
		// Implement me!
		Node<T> nodePointer = firstNode;
		while(nodePointer != null)
		{
			out.println(nodePointer.getItem()+printDelim+ nodePointer.getInstanceCount());
			nodePointer = nodePointer.getNextNode();
		}
	} // end of print()
	
} // end of class LinkedListMultiset


