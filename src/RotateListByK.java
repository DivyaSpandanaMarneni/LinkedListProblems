import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 12/21/2016.
 */
public class RotateListByK {

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
            n = n.next;
        }

        System.out.println();
    }

    public int getLength(){
        Node n = head;
        int k =0;
        while(n != null){
            k++;
            n=n.next;
        }
        return k;

    }

    //find n-k element from last and after element detach from the list and attach it at the starting
    public Node rotateByK(int k){

        int n = getLength();
        int N = n-k;

        Node node = head;
        int count =0;
        Node temp = null;
        while(node!= null){
            count ++;
            temp = node;
            node = node.next;
            if(count == N)
                break;


        }
        Node newHead = node;
        temp.next = null;

        while(node.next!= null){
            node= node.next;
        }

        node.next = head;
        head = newHead;


        return head;
    }

    public static void main(String[] args) throws IOException{
        

        RotateListByK rlk = new RotateListByK();

        System.out.println("Enter the size of the list");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        System.out.println("Enter the elements for the linked list");

        int count = 0;
        int element;
        while(count < size){
            element = Integer.parseInt(br.readLine());
            rlk.addNode(element);
            count++;
        }


        rlk.printElements(head);
        System.out.println("Enter the value for k");
        int k = Integer.parseInt(br.readLine());

        System.out.println("The length is "+rlk.getLength());

        rlk.rotateByK(k);

        System.out.println("After rotation");
        rlk.printElements(head);

    }



}
