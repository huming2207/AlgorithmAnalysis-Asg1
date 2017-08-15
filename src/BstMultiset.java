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
		rootNode = recursiveAdder(rootNode, item);
	} // end of add()

	private BstNode<T> recursiveAdder(BstNode<T> node, T item)
	{
		// If the node is null, return a new node alongside with item added in.
		if(node == null)
		{
			return new BstNode<>(item);
		}

		// If the node's item is larger than the new item, then put it to left
        if(node.getItem().compareTo(item) > 0)
        {
            node.setLeftNode(recursiveAdder(node.getLeftNode(), item));
            return node;
        }

        // If the node's item is larger than the new item, then put it to right
        else if(node.getItem().compareTo(item) < 0)
        {
            node.setRightNode(recursiveAdder(node.getRightNode(), item));
            return node;
        }

        // If the node's item is the same as the new item, append instance count
        else
        {
            node.setInstanceCount(node.getInstanceCount() + 1);
            return node;
        }


	} // end of add()


	public int search(T item)
	{
		BstNode<T> result = searchNode(rootNode, item);

		// Return the instance count if found, or return 0.
		return (result != null) ? result.getInstanceCount() : 0;
	} // end of add()

	private BstNode<T> searchNode(BstNode<T> node, T item)
	{
		// Stop if null
		// i.e. no node at all in the BST, not necessary to search
		if(node == null) return null;


		// Search left node if the node's item is larger than this item
		if(node.getItem().compareTo(item) > 0)
		{
			node = searchNode(node.getLeftNode(), item);
		}

		// Search right node if the node's item is smaller than this item
		else if(node.getItem().compareTo(item) < 0)
		{
			node = searchNode(node.getRightNode(), item);
		}

		// Return the node every time
		return node;
	}


	public void removeOne(T item)
	{
		BstNode<T> node = searchNode(rootNode, item);

		// If node is null, stop
		if(node == null) return;

		// If node instance count is larger 1
		if(node.getInstanceCount() > 1)
		{
			node.setInstanceCount(node.getInstanceCount() - 1);
		}

		// ...or, if there is only 1 instance, remove the node totally.
		else
		{
			removeAll(item);
		}

	} // end of removeOne()
	
	
	public void removeAll(T item)
	{
		rootNode = recursiveRemove(rootNode, item);
	} // end of removeAll()


	private BstNode<T> recursiveRemove(BstNode<T> node, T item)
	{
		// Stop if null
		// i.e. no node at all in the BST, not necessary to search
		if(node == null) return null;


		// Search left node if the node's item is larger than this item
		if(node.getItem().compareTo(item) > 0)
		{
			node.setLeftNode(recursiveRemove(node.getLeftNode(), item));
		}

		// Search right node if the node's item is smaller than this item
		else if(node.getItem().compareTo(item) < 0)
		{
			node.setRightNode(recursiveRemove(node.getRightNode(), item));
		}

		// If matches (compareTo == 0), then do deletion
		else
		{
			// If there is no right node, do deletions at its left node
			if(node.getRightNode() == null)
			{
				node = node.getLeftNode();
			}
			// If there is no left node, do deletions at its right node
			else if(node.getLeftNode() == null)
			{
				node = node.getRightNode();
			}
			// If there are two child nodes...
			else
			{

				BstNode<T> minNode = searchMinNode(node.getRightNode());

				node.setItem(minNode.getItem());

				node.setInstanceCount(minNode.getInstanceCount());

				node.setRightNode(recursiveRemove(node.getRightNode(), minNode.getItem()));
			}

		}

		return node;
	}

	private BstNode<T> searchMinNode(BstNode<T> node)
	{
		if(node == null) return node;

		if(node.getLeftNode() != null)
		{
			searchMinNode(node.getLeftNode());
			return node;
		}
		else
		{
			return node;
		}
	}

	public void print(PrintStream out)
	{
		printByAscendingOrder(rootNode,out);
	} // end of print()

	private void printByAscendingOrder(BstNode<T> node, PrintStream out)
	{
		// If node is null, stop
		if(node == null) return;

		// Start iterate from left node, then print, then right node
		printByAscendingOrder(node.getLeftNode(), out);
		out.println(node.getInstanceCount() + printDelim + node.getItem().toString());
		printByAscendingOrder(node.getRightNode(), out);
	}

} // end of class BstMultiset
