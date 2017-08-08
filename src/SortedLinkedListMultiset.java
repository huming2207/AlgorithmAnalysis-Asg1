import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
    private Node<T> firstNode;
    private Node<T> lastNode;


	public SortedLinkedListMultiset()
	{
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

    }

	public void removeOne(T item)
    {
        Node<T> node = searchHelper(item);
        removeNode(node);

        updateInstanceCount(item, -1);

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
        boolean swapped = false;
        Node<T> selectedNode = firstNode;
        Node<T> nextSelectedNode = firstNode.getNextNode();

        while(swapped)
        {
            swapped = false;
            while(selectedNode != null && selectedNode.getNextNode() != null)
            {
                if(selectedNode.getInstanceCount() > selectedNode.getNextNode().getInstanceCount())
                {
                    Node<T> tempNode = selectedNode;
                    selectedNode = nextSelectedNode;
                    nextSelectedNode = tempNode;
                    swapped = true;
                }

                if(swapped)
                {

                }

                selectedNode = nextSelectedNode;
                nextSelectedNode = nextSelectedNode.getNextNode();
            }
        }
    }


} // end of class SortedLinkedListMultiset