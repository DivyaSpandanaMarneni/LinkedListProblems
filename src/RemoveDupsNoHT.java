import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/11/2016.
 */
public class RemoveDupsNoHT {

    public static Node head = null;

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            Node next = null;
        }
    }

    public void push(int data){

        Node node = new Node(data);
        node.next = head;
        head= node;
    }

    public void removeDuplicates(Node current){ //calling this function for every node so that we check until that node if any elements are present
        //if present we update the prev to the next of current node

        if(current == head && head.next == null){
            System.out.println("This is head");
            return ;
        }

        Node n = head;
        System.out.println("Head data is "+n.data);
        Node prev = n; // for maintaining prev so that current can be removed and prev.next goes to current.next

        //n iterates from head to current
        // check whether if current.data is present from head to current-1 nodes
        int count =0;
        while(n != current){

            if(n.data == current.data) {
                count++;
            }
            prev = n;
            n=n.next;
            //current = n.next;


        }
        if(count >0 ) {
            prev.next = current.next;

        }
    }

    public void printElements(){

        Node n = head;

        while(n != null){
            System.out.print(n.data+"->");
            n=n.next;
        }
    }



    public static void main(String[] args) throws IOException{

        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");
        RemoveDupsNoHT rd = new RemoveDupsNoHT();



        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            rd.push(element);
            count++;
        }


        rd.printElements();



        System.out.println("Deleting the duplicate entries");

        Node n = head.next;
        while(n!= null){
            rd.removeDuplicates(n);
            n=n.next;
        }

        rd.printElements();
    }
}
