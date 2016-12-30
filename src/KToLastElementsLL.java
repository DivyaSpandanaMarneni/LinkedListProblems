import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/11/2016.
 */
public class KToLastElementsLL { //finding the elements from kth position to the last element

    public  static Node head = null;

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

    public void printElements(Node k){

        Node n =k;
        while(n!= null){
            System.out.print(n.data+"->");
            n=n.next;
        }
        System.out.println();

    }

    public Node returnElements(int k){ //return kth element

        int count =0;
        Node n = head;
        Node temp = null;
        if(k==1)
            return head;

        while(n != null){
            temp = n;
            n=n.next;
            count++;

            if(count == k)
                return temp;

        }

        return null;
    }

    public static void main(String[] args) throws IOException{

        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");
        KToLastElementsLL rd = new KToLastElementsLL();



        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            rd.push(element);
            count++;
        }


        rd.printElements();

        System.out.println("Enter the value for k");
        int k = Integer.parseInt(br.readLine());

        Node returnedHead = rd.returnElements(k);


        rd.printElements(returnedHead);
    }
}
