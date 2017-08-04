import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
    private Node<T> firstNode;
    private Node<T> currentNode;
    private Node<T> lastNode;

	public SortedLinkedListMultiset()
	{
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item)
    {
        Node newNode = new Node<>(item);

        // Detect if the first node is null
		if(firstNode == null)
        {
            firstNode = newNode;
        }
        else
        {
            currentNode.setPreviousNode(currentNode);
        }

	} // end of add()
	
	
	public int search(T item)
    {
		// Implement me!		
		
		// default return, please override when you implement this method
		return 0;
	} // end of search()
	
	
	public void removeOne(T item)
    {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item)
    {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out)
    {
		// Implement me!
	} // end of print()

    public void bubbleSort()
    {

    }

} // end of class SortedLinkedListMultiset