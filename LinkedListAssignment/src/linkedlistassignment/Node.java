package linkedlistassignment;

/**
 *
 * @author Eric Lin
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    //singly LinkedList
    private T data;
    private Node<T> next;
    
    /**
     * node value required to create node
     * @param data node value
     */
    public Node(T data){
        this.data = data;
    }
    
    /**
     * compares nodes
     * @param other other node
     * @return 
     */
    @Override
    public int compareTo(Node<T> other){
        if(this.getData().compareTo(other.getData()) > 0)
            return 1;
        else if(this.getData().compareTo(other.getData()) < 0)
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
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
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
