package linkedlistassignment;

/**
 *
 * @author Eric Lin
 */
public class LinkedList<Patient extends Comparable<Patient>> {

    //first node in chain
    private Node head = null;
    //last node in chain
    private Node tail = null;
    //number of elements in LinkedList
    private int size = 0;

    public LinkedList() {
    }

    /**
     * adds node to last position
     *
     * @param node node being added
     */
    public void add(Object item) {
        Node temp = new Node(item);
        //first node being added
        if (getHead() == null) {
            setHead(temp);
            setTail(temp);
        } //links node to current last node
        else {
            getTail().setNext(temp);
            //identifies new node as the tail node
            setTail(getTail().getNext());
        }
        setSize(getSize() + 1);
    }

    /**
     * adds node to given position. Similarly to arrays, this method will return
     * an exception if the index taken in is out of bounds.
     *
     * @param node node to be added
     * @param pos index to add node
     */
    public void add(Node node, int pos) {
        Node temp = get(pos - 1);
        node.setNext(temp.getNext());
        temp.setNext(node);
        //temp.prev.next = node;
        if (pos == getSize() - 1) {
            setTail(temp.getNext());
        }
        setSize(getSize() + 1);
    }

    /**
     * Returns exception is there is an empty chain
     */
    public void remove() {
        Node temp = get(getSize() - 2);
        setTail(temp);
        getTail().setNext(null);
        setSize(getSize() - 1);
    }

    /**
     *
     * @param pos
     */
    public void remove(int pos) {
        Node temp = get(pos - 1);
        if (pos == getSize() - 1) {
            remove();
        } //links nodes beside chosen node
        else if (pos == 0) {
            setHead(getHead().getNext());
            setSize(getSize() - 1);
        } else {
            temp.setNext(temp.getNext().getNext());
            setSize(getSize() - 1);
        }
    }

    /**
     *
     * @return number of elements in LinkedList
     */
    public int size() {
        return getSize();
    }

    /**
     * gets node at index in LinkedList
     *
     * @param pos index in Linked List
     * @return node in LinkedList
     */
    public Node get(int pos) {
        Node temp = getHead();
        //case where pos is last index
        if (pos == getSize() - 1) {
            return getTail();
        }
        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * adds elements in other LinkedList into this LinkedList
     *
     * @param other other LinkedList
     */
    public void add(LinkedList other) {
        getTail().setNext(other.getHead());
        setSize(this.size() + other.size());
    }

    /**
     * Replaces node at index in LinkedList
     *
     * @param node replacement node
     * @param pos index in LinkedList
     */
    public void set(Node node, int pos) {
        Node temp = get(pos - 1);
        //head case
        if (pos == 0) {
            node.setNext(getHead().getNext());
            setHead(node);
        }
        //tail case
        else if (pos == size() - 1) {
            temp.setNext(node);
            setTail(temp.getNext());
        } //sets node by replacing node at that position
        else {
            node.setNext(temp.getNext().getNext());
            temp.setNext(node);
        }
    }

    /**
     * 
     * @return gets string value of LinkedList
     */
    @Override
    public String toString() {
        String temp = "[";
        Node cur = getHead();
        while (true) {
            if (cur != null) {
                temp += (cur + ",");
            } else {
                break;
            }
            cur = cur.getNext();
        }
        temp = temp.substring(0,temp.length()-1);
        temp += "]";
        return temp;
    }

    /**
     * @return the head
     */
    public Node getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public Node getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
