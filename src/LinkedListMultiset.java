import java.io.PrintStream;

public class LinkedListMultiset<T extends Comparable<T>> extends Multiset<T>
{
    // The first node (HEAD)
    private Node<T> firstNode;

    // The last node (TAIL)
    private Node<T> lastNode;

    private int countNode;

    public LinkedListMultiset()
    {
        firstNode = null;
        lastNode = null;
        countNode = 0;
    } // end of LinkedListMultiset()


    public void add(T item)
    {
        // Create a new node
        Node<T> newNode = new Node<>(item);
        newNode.setInstanceCount(updateInstanceCount(item, 1));

        if (firstNode == null)
        {
            // Here we don't need to do any search, since the first node is null (whole list is empty)
            firstNode = newNode;
            lastNode = newNode;
        }
        else
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
        countNode++;
    } // end of add()

    private int updateInstanceCount(T item, int update)
    {
        Node<T> nodePointer = firstNode;
        int count = 1;
        while (nodePointer != null)
        {
            if (nodePointer.getItem().equals(item))
            {
                nodePointer.setInstanceCount(nodePointer.getInstanceCount() + update);
                count = nodePointer.getInstanceCount();
            }
        }
        return count;
    }


    public int search(T item)
    {
        Node<T> nodePointer = searchHelper(item);
        return (nodePointer != null) ? nodePointer.getInstanceCount() : 0;
    } // end of search()

    private Node<T> searchHelper(T item)
    {
        Node<T> nodePointer = firstNode;
        while (nodePointer != null)
        {
            if (nodePointer.getItem().equals(item))
            {
                return nodePointer;
            }

            nodePointer = nodePointer.getNextNode();
        }
        return null;
    }

    private void removeNode(Node<T> node)
    {
        // stop if the node is null
        if(node == null)
        {
            return;
        }

        if (firstNode.equals(node) && lastNode.equals(node))
        {
            firstNode = null;
            lastNode = null;
        }
        if (node.getPreviousNode() != null)
        {
            node.getPreviousNode().setNextNode(node.getNextNode());
        }
        else
        {
            firstNode = node.getNextNode();
        }
        if (node.getNextNode() != null)
        {
            node.getNextNode().setPreviousNode(node.getPreviousNode());
        }
        else
        {
            lastNode = node.getPreviousNode();
        }
        node.setItem(null);
        countNode--;
    }

    public void removeOne(T item)
    {
        Node<T> node = searchHelper(item);

        if(node != null && node.getInstanceCount() > 1)
        {
            node.setInstanceCount(node.getInstanceCount() - 1);
        }
        else
        {
            removeNode(node);
        }

    } // end of removeOne()


    public void removeAll(T item)
    {
        // remove the node directly
        removeNode(searchHelper(item));
    } // end of removeAll()


    public void print(PrintStream out)
    {
        Node<T> nodePointer = firstNode;
        while (nodePointer != null)
        {
            out.println(nodePointer.getItem() + printDelim + nodePointer.getInstanceCount());
            nodePointer = nodePointer.getNextNode();
        }
    } // end of print()

} // end of class LinkedListMultiset


