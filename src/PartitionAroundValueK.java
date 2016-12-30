import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 12/23/2016.
 */

//this can be solved by creating two nodes one for creating a lesser than k list and pivot for joining elemnts greater than pivot
    // once the two lists are done we can join them by eliminating the pivot
public class PartitionAroundValueK {

    public static Node head = null;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printElements(Node node){
        Node n = node;
        while(n!= null){
            System.out.print(n.data+"->");
            n=n.next;

        }
        System.out.println();
    }

    public Node partition(Node n, int k){

        Node node = n;

        Node pivot = new Node(k);
        Node greater = pivot;
        Node root = new Node(0);
        Node lesserEqual = root;
        while(n != null){

            node = n.next;
            if(n.data > k){
                greater.next = n;
                greater = n;
                greater.next = null;
            }
            else{
                lesserEqual.next = n;
                lesserEqual = n;
                lesserEqual.next = null;
            }

            n = node;






            //return root.next;
        }
        lesserEqual.next = pivot.next;

        return root.next;
    }

    public static void main(String[] args) throws IOException{

        PartitionAroundValueK pk = new PartitionAroundValueK();
        System.out.println("Enter the size of the list");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        System.out.println("Enter the elements for the linked list");

        int count = 0;
        int element;
        while(count < size){
            element = Integer.parseInt(br.readLine());
            pk.addNode(element);
            count++;
        }

        pk.printElements(head);

        System.out.println("Enter the value of k");
        int k = Integer.parseInt(br.readLine());

        Node node = pk.partition(head,k);

        pk.printElements(node);


    }
}
