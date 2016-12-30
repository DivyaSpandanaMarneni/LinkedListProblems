import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by marne on 12/13/2016.
 */

//find the last node in the list that satisfies the constraint n%k == 0
public class FindModularNode {

    public static Node head = null;
    static class Node{
        int data;
        Node next;

        Node(int data){
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
        System.out.println();
    }

    //find the length of the list
    public int listLength(){
        Node node = head;
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    //find last element that satisfies n%k == 0;
    //complexity is O(n)
    public Node findModularLast(int k){
        int n = 0;
        Node node = head;
        Node modular = null;
        while(node != null){
            n++;
            if(n%k == 0){
                modular = node;
            }
            node = node.next;

        }
        return modular;

    }


    public static void main(String[] args) throws IOException{

        FindModularNode fmn = new FindModularNode();

        fmn.head = new Node(10);
        fmn.head.next = new Node(5);
        fmn.head.next.next = new Node(11);
        fmn.head.next.next.next = new Node(20);
        fmn.head.next.next.next.next = new Node(21);
        fmn.head.next.next.next.next.next = new Node(22);
        fmn.head.next.next.next.next.next.next = new Node(23);
        fmn.printElements();

        int listLength = fmn.listLength();
        System.out.println("The length is " + listLength);

        System.out.println("Enter the value for k");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Node modular = fmn.findModularLast(k);
        System.out.println("The element is "+modular.data);




    }


}
