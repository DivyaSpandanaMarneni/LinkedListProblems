import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * Created by marne on 10/11/2016.
 */
public class RemoveDuplicates {
    public static Node head = null;
    //take a temporary buffer with range of the elements

    class Node{
        int data;
        Node next = null;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void printElements(){
        Node n = head;

        while(n != null){
            System.out.print(n.data+"->");
            n=n.next;
        }
    }

    public void removeDuplicates(Node n){
        n = head; //take head = n and current = next of n and increment them by checking whether the current element is present in the
        //hash table or not and based  on that take a decision of updating the pointers and removing the duplicate nodes

        Node current = n.next;
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        ht.put(n.data,n.data);
        while(n != null){
            if(ht.contains(current.data)){
               n.next = current.next;
                //n= current.next;
                current.next = null;
                //n.next= current;
                //current=null;

            }
            else {
                ht.put(current.data, current.data);

            }
            n=n.next;
            if(current.next != null)
            current = current.next;
        }

        //ht.put(n.data,n.data);

    }






    public static void main(String[] args) throws IOException{

        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");
        RemoveDuplicates rd = new RemoveDuplicates();



        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            rd.push(element);
            count++;
        }


        rd.printElements();



        System.out.println("Deleting the duplicate entries");

        rd.removeDuplicates(head);

        rd.printElements();


    }

}
