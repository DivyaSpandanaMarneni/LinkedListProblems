import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 12/12/2016.
 */

//selecting the winner by eliminating every mth member
public class JosephusCircle {

    public static Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void printElements(Node head){
        Node node = head;

        do{

            System.out.print(node.data+"->");
            node = node.next;

        }while(node != head);
        System.out.print(node.data);
        System.out.println();
    }

    public Node selectWinner(int m){
        Node node = head;
        Node temp = null;
        int count = 1;
        while(node.next!=node) {
            count = 1;
            while (count < m) {
                temp = node;
                node = node.next;
                count++;
            }

            temp.next = node.next;






        }

        return node;




    }


    public static void main(String[] args) throws IOException{

        JosephusCircle jc = new JosephusCircle();

        JosephusCircle.head = new Node(5);
        JosephusCircle.head.next = new Node(8);
        JosephusCircle.head.next.next = new Node(10);
        JosephusCircle.head.next.next.next = new Node(6);
        JosephusCircle.head.next.next.next.next = new Node(7);
        JosephusCircle.head.next.next.next.next.next = head;

        System.out.println("Enter the value for elimation number");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        Node winner  = jc.selectWinner(m);
        System.out.println("The winner is "+winner.data);



    }


}
