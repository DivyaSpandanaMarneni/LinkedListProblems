import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/13/2016.
 */
public class PartitionAroundK2 {

    public static Node head1 = null; // in linked list 1
    public static Node head2 = null; // in a newly created linkedlist we add before and after the current nodes
    public static Node tail2 = null; // in the newly created linkedlist we will add the nodes after the checking node
    //Make sure that new list has new instance of a node. if same references are used then it may go into infinite loop

    public class Node{
        int data;
        Node next = null;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        Node n = new Node(data);
        n.next = head1;
        head1=n;
    }


    public void pushBefore(int data){

        Node n = new Node(data);
        n.next = head2;
        head2 = n;

        //return head1;
    }

    public void pushAfter(int data){

        Node n = new Node(data);
        tail2.next = n;
        tail2 = n;

    }

    public void partitionAround(int element){

        PartitionAroundK2 pk = new PartitionAroundK2();
        Node iterator = head1;
        Node check = null;
        Node newLL = null;
        while(iterator != null){
            if(iterator.data == element) {
                check = iterator;
                break;
            }
            else
                iterator = iterator.next;
        }

        System.out.println("Found "+element+" and partitioning around it");

        iterator = head1;
        newLL = new Node(check.data);

        head2 = newLL;
        System.out.println("head2"+head2.data);
        tail2 = newLL;
        System.out.println("tail2"+tail2.data);

        while (iterator != null){

            if(iterator == check){
                iterator = iterator.next;
                continue;
            }

            if(iterator.data <= check.data){
               pk.pushBefore(iterator.data);
            }
            else
            pk.pushAfter(iterator.data);

            iterator = iterator.next;

        }

    }

    public void printElements(Node start){

        Node n = start;

        while(n!= null){
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

        PartitionAroundK2 k2 = new PartitionAroundK2();



        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            k2.push(element);
            count++;
        }


        k2.printElements(head1);

        System.out.println("Enter the value for partion element");

        int partion = Integer.parseInt(br.readLine());

        k2.partitionAround(partion);

        k2.printElements(head2);




    }
}
