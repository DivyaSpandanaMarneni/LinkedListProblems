import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by marne on 12/13/2016.
 */
public class FindModularNodeFromEnd {

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

    public void printElements() {
        Node node = head;

        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }

    //find n%k == 0 from last
    //reverse the linked list
    //then find the n%k from starting



    public static void main(String[] args) throws IOException{

        System.out.println("Enter the elements in the linked list");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");
        FindModularNodeFromEnd fm = new FindModularNodeFromEnd();



        int count = 0;
        int element;
        while(count <size){
            element = Integer.parseInt(br.readLine());
            fm.addNode(element);
            count++;
        }


        fm.printElements();
    }


}
