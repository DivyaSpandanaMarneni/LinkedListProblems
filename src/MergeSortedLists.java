/**
 * Created by marne on 10/21/2016.
 */
public class MergeSortedLists {

    public static Node head1;
    public static Node head2;

    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push1(int data){
        Node node = new Node(data);
        node.next = head1;
        head1= node;
    }

    public void push2(int data){
        Node node = new Node(data);
        node.next = head2;
        head2= node;
    }

    public void printElements(Node node){
        Node n = node;
        while(n!= null){
            System.out.println(n.data+"->");
            n=n.next;
        }
    }

    public static void main(String[] args){

        System.out.println("Read the two linked lists");




    }

}
