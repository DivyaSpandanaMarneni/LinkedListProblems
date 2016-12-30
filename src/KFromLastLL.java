import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/11/2016.
 */
public class KFromLastLL { // it is asking to find k from last.
    //idea is to reverse the linked list and find k from first.

    public static Node head = null;
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){

        Node node = new Node(data);
        node.next = head;
        head= node;
    }

    public void printElements(){

        Node n = head;

        while(n != null){
            System.out.print(n.data+"->");
            n=n.next;
        }
    }

    public Node reverseTheLL(){ // for reverse we generally need two variables other than head

        Node start = head;
        Node current = start.next;
        //Node temp = head;
        if(head == null || head.next == null)
            return head;
        head.next = null;
        while(current!= null){


            head = current;
            current = current.next;
            head.next = start;
            start = head;




        }
        return head;

    }

    public Node findKtElement(int k){

        int count = 1;
        Node n = head;

        while(n!=null){

            n=n.next;
            count++;

            if(count == k)
                return n;

        }


    return null;
    }


    public static void main(String[] args) throws IOException{
    int element;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the size of the linked list");
    int size = Integer.parseInt(br.readLine());
    System.out.println("Enter the elements in the Linked list");

        KFromLastLL rd = new KFromLastLL();



    int count = 0;

    while(count <size){
        element = Integer.parseInt(br.readLine());
        rd.push(element);
        count++;
    }


    rd.printElements();

    System.out.println("Enter the value for k");

        int k = Integer.parseInt(br.readLine());

        System.out.println("Reverse the linked list");

        //logic for reversing the list

        Node n = rd.reverseTheLL();

        System.out.println("The reverse list is :");
        rd.printElements();
        System.out.println("Now the head is "+n.data);

        Node node = rd.findKtElement(k);

        System.out.println("The "+k+"th element from last is "+node.data);






}
}