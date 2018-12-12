package linkedlistassignment;

/**
 *
 * @author Eric Lin
 */
public class Node<T> implements Comparable<Node>{
    //singly LinkedList
    private int data;
    private Node<T> next;
    
    /**
     * node value required to create node
     * @param data node value
     */
    public Node(Object data){
        this.data = data;
    }
    
    /**
     * compares nodes
     * @param other other node
     * @return 
     */
    @Override
    public int compareTo(Node other){
        if(this.getData() > other.getData())
            return 1;
        else if(this.getData() < other.getData())
            return -1;
        else
            return 0;
    }
    
    /**
     * returns node value
     * @return node value as string
     */
    @Override
    public String toString(){
        return ""+getData();
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
