package linkedlistassignment;

/**
 * 
 * @author Eric Lin
 */
public class Main {
    /**
     * driver method
     * @param args 
     */
    public static void main(String[]args){
        LinkedList<Patient> list = new LinkedList<Patient>();
        //adds node 1 and 2
        list.add(new Patient("Eric","Lin"));
        list.add(new Patient("Andrew","Su"));
        list.add(new Patient("Carl","Wu"),1);
        list.remove();
        LinkedList<Patient> list2 = new LinkedList<Patient>();
        list2.add(new Patient("Bill","Cui"));
        list.add(list2);
        System.out.println(list);
    }
}
