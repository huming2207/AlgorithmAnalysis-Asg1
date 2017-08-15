import java.io.PrintStream;

public class SortedLinkedListMultiset<T extends Comparable<T>> extends Multiset<T>
{
    private Node<T> firstNode;
    private Node<T> lastNode;

	public SortedLinkedListMultiset()
	{
	    firstNode = null;
	    lastNode = null;
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item)
    {
        // Create a new node
        Node<T> newNode = new Node<>(item);

        // If the node pointers are all null, assign the new node to them
        // Inverted the if-else statement with LinkedListMultiset as Intellij IDEA IDE will
        //  keep warning me the code is duplicate (and since this is an assignment, I can't merge these two).
        if(firstNode != null)
        {
            // Run a search before addition
            Node<T> searchResult = searchHelper(item);

            if (searchResult != null)
            {
                // If there is a node already exists with the same item, just +1 for instance count.
                searchResult.setInstanceCount(searchResult.getInstanceCount() + 1);
            }
            else
            {
                // ...otherwise, add the item to a new node
                newNode.setPreviousNode(lastNode);
                lastNode.setNextNode(newNode);
                lastNode = newNode;
            }

        }
        else
        {
            firstNode = newNode;
            lastNode = newNode;
        }



        // Do bubble sort after adding procedure.
        bubbleSortByAlphabeticalOrder();
	} // end of add()



	public int search(T item)
    {
        Node<T> node = searchHelper(item);

        return (node != null) ? node.getInstanceCount() : 0;
	} // end of search()

    private Node<T> searchHelper(T item)
    {
        Node<T> nodePointer = firstNode;

        while (nodePointer != null)
        {
            if(nodePointer.getItem().equals(item))
            {
                return nodePointer;
            }

            // Move to next node
            nodePointer = nodePointer.getNextNode();
        }

        return null;
    }

    private void removeNode(Node<T> node)
    {
        // If there is only one node...
        if(firstNode.equals(node) && lastNode.equals(node))
        {
            firstNode = null;
            lastNode = null;

            node.setItem(null);
            return;
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

	public void removeOne(T item)
    {
        Node<T> node = searchHelper(item);

        // If node is null (i.e. item not found in the list), stop.
        if(node == null) return;

        // If node is not null and instance is greater than 1, minus 1 instead of remove the node
        //  ...or if it is 1, remove it (since there is only 1 left)
        if(node.getInstanceCount() > 1)
        {
            node.setInstanceCount(node.getInstanceCount() - 1);
        }
        else
        {
            // Remove the node if there is only 1 instance left
            removeNode(node);

            // Do a sort after removal
            bubbleSortByAlphabeticalOrder();
        }


	} // end of removeOne()
	
	
	public void removeAll(T item)
    {
        // Find out the node
        Node<T> node = searchHelper(item);

        // If node is null (i.e. item not found in the list), stop.
        if(node == null) return;

        // Instead of deducting instance count, here we just remove the node.
        removeNode(node);

        // Run sort
        bubbleSortByAlphabeticalOrder();
	} // end of removeAll()
	
	
	public void print(PrintStream out)
    {
        Node<T> nodePointer = firstNode;

        while(nodePointer != null)
        {
            out.println(nodePointer.getItem() + printDelim + nodePointer.getInstanceCount());
            nodePointer = nodePointer.getNextNode();
        }
	} // end of print()

    private void bubbleSortByAlphabeticalOrder()
    {
        // Reference: some design ideas followed the lab source code template (Lab #1 and #2)
        boolean swapped;

        Node<T> nodePointer = firstNode;

        // Only runs if there are more than 1 nodes.

        do
        {
            swapped = false;

            // Do the comparison by looping around
            while (nodePointer.getNextNode() != null)
            {
                // Swap when the first node's alphabetical order is "larger" than the next one
                if(nodePointer.getItem().compareTo(nodePointer.getNextNode().getItem()) > 0)
                {
                    swapped = true;
                    swapNode(nodePointer, nodePointer.getNextNode());
                }

                nodePointer = nodePointer.getNextNode();
            }
        }
        while(swapped);
    }


    private void swapNode(Node<T> firstNode, Node<T> secondNode)
    {
        // Create middle pointer to swap
        T secondItem = secondNode.getItem();
        int secondInstance = secondNode.getInstanceCount();

        // Set second node's item and instance count to the first ones
        secondNode.setItem(firstNode.getItem());
        secondNode.setInstanceCount(firstNode.getInstanceCount());

        // Set first node's item and instance count to the second ones (from the pointer)
        firstNode.setItem(secondItem);
        firstNode.setInstanceCount(secondInstance);
    }


} // end of class SortedLinkedListMultiset