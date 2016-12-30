import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/21/2016.
 */
public class ReverseLL2 {

    public static Node head = null;

    public class Node{
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
        while(n!= null){
            System.out.println(n.data+"->");
            n=n.next;
        }
    }

    public Node reverse(Node n ){

        Node nowAt = n;
        Node prev = null;
        Node next = null;

        if(head == null)
            return null;
        if(head.next == null)
            return head;

        while(nowAt != null) {
            next = nowAt.next;
            nowAt.next = prev;
            prev = nowAt;
            //if(next != null)
            nowAt = next;
        }
        return prev;
    }

    public static void main(String[] args) throws IOException{

        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");
        ReverseLL2 rd = new ReverseLL2();



        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            rd.push(element);
            count++;
        }

        System.out.println("Before reversing");
        rd.printElements();

        Node node = rd.reverse(head);

        head = node;
        System.out.println("after reversing");
        rd.printElements();
    }
}
