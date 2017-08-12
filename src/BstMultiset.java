import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T extends Comparable<T>> extends Multiset<T>
{
	private BstNode<T> rootNode;

	public BstMultiset()
	{
		rootNode = null;
	} // end of BstMultiset()

	public void add(T item)
	{

	} // end of add()

	private BstNode<T> recursiveAdder(BstNode<T> node, T item)
	{
		// If the root node is null, return a new node directly (add to root node)
		if(rootNode == null)
		{
			return new BstNode<>(item);
		}

		// If the node's item itself is null, add the item into it.
		if(node.getItem() == null)
		{
			node.setItem(item);
			return node;
		}

		// If the node's item is larger than the new item, then put it to left
        if(node.getItem().compareTo(item) > 0)
        {
            node.setLeftNode(recursiveAdder(node.getLeftNode(), item));
            return node; // Useless but just shut up the compiler
        }

        // If the node's item is larger than the new item, then put it to right
        else if(node.getItem().compareTo(item) < 0)
        {
            node.setRightNode(recursiveAdder(node.getRightNode(), item));
            return node; // Useless but just shut up the compiler
        }

        // If the node's item is the same as the new item, append instance count
        else
        {
            node.setInstanceCount(node.getInstanceCount() + 1);
            return node; // Useless but just shut up the compiler
        }


	} // end of add()


	public int search(T item) {
		// Implement me!

		// default return, please override when you implement this method
		return 0;
	} // end of add()


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

} // end of class BstMultiset
