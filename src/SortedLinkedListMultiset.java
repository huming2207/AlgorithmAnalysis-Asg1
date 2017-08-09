import java.io.PrintStream;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int nodeCount;

	public SortedLinkedListMultiset()
	{
	    firstNode = null;
	    lastNode = null;
	    nodeCount = 0;
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item)
    {
        // Create a new node
        Node<T> newNode = new Node<>(item);
        newNode.setInstanceCount(updateInstanceCount(item, 1));

        // If the node pointers are all null, assign the new node to them
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

        nodeCount++;

        // Do bubble sort after adding procedure.
        bubbleSort();
	} // end of add()
	

    private int updateInstanceCount(T item, int update)
    {
        // Set the first node to first node
        Node<T> nodePointer = firstNode;
        int count = 1;

        // Do a while loop to search these nodes
        while (nodePointer != null)
        {
            if(nodePointer.getItem().equals(item))
            {
                nodePointer.setInstanceCount(nodePointer.getInstanceCount() + update);
                count = nodePointer.getInstanceCount();
            }

            nodePointer = nodePointer.getNextNode();
        }

        // return the count
        return count;
    }



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
        nodeCount--;
    }

	public void removeOne(T item)
    {
        Node<T> node = searchHelper(item);
        removeNode(node);

        updateInstanceCount(item, -1);
        bubbleSort();
	} // end of removeOne()
	
	
	public void removeAll(T item)
    {
        Node<T> nodePointer = firstNode;

        while (nodePointer != null)
        {
            if(nodePointer.getItem().equals(item))
            {
                removeNode(nodePointer);
            }

            // Move to next node
            nodePointer = nodePointer.getNextNode();
        }
        bubbleSort();
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

    public void bubbleSort()
    {
        // Reference: some design ideas followed the lab source code template (Lab #1 and #2)
        boolean swapped;

        Node<T> nodePointer = firstNode;

        // Only runs if there are more than 1 nodes.
        if(nodeCount > 1)
        {
            do
            {
                swapped = false;

                // Do the comparison by looping around
                for(int loopIndex = 0; loopIndex < getNodeCount() - 1; loopIndex++)
                {
                    // Swap when the first node's instance count is larger than the next one
                    if(nodePointer.getInstanceCount() > nodePointer.getNextNode().getInstanceCount())
                    {
                        swapped = true;
                        swapNode(nodePointer, nodePointer.getNextNode());
                    }

                    nodePointer = nodePointer.getNextNode();
                }
            }
            while(swapped);
        }
    }

    private int getNodeCount()
    {
        Node<T> nodePointer = firstNode;
        int nodeCount = 0;

        while(nodePointer != null)
        {
            nodeCount++;
            nodePointer = nodePointer.getNextNode();
        }

        return nodeCount;
    }


    private void swapNode(Node<T> firstNode, Node<T> secondNode)
    {
        // Assume we've got 4 nodes, 1, 2, 3, 4;
        // SWAP 2 AND 3...

        // 2.Next -> 4
        firstNode.setNextNode(secondNode.getNextNode());

        // 3.Previous -> 1
        secondNode.setPreviousNode(firstNode.getPreviousNode());

        // 3.Next -> 2
        secondNode.setNextNode(firstNode);

        // 2.Previous -> 3
        firstNode.setPreviousNode(secondNode);
    }


} // end of class SortedLinkedListMultiset