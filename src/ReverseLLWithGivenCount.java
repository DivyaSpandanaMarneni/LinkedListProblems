import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by marne on 12/2/2016.
 */
public class ReverseLLWithGivenCount {

    public static Node head =null;
    public static Node newHead = null;
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

    public void addNodeNewLL(Node curr , int data){
        Node newNode = new Node(data);
        newNode.next = curr;
        curr = newNode;
        newHead = curr;
    }

    public void printLinkedList(Node node){
        Node n = node;
        while(n!= null){

            System.out.print(n.data+"->");
            n = n.next;
        }
    }

    public Node reverseInChunks(int size){

        //Node newHead = null;
        Node currList = head;
        Stack<Integer> stack = new Stack<Integer>();

        int count =0;

        while(currList != null && currList.next != null){

            while(count < size){
                stack.push(currList.data);
                currList = currList.next;
                count = count+1;
            }

            while(count != 0) {
                addNodeNewLL(newHead,stack.pop());
                count = count-1;
            }

        }

        if(currList != null && currList.next == null){
            addNodeNewLL(newHead,currList.data);
        }

        //reverse this linked list to get the required result


        Node curr = newHead.next;
        Node temp = curr.next;
        newHead.next = null;

        while(temp != null ){

           curr.next = newHead;
            newHead = curr;
            curr = temp;
            //if(temp.next != null)
            temp = temp.next;


        }
        curr.next = newHead;
        newHead=curr;

        return newHead;
    }






    public static void main(String[] args) throws IOException{

        System.out.println("Enter the data for linkedlist");

        ReverseLLWithGivenCount rgc = new ReverseLLWithGivenCount();

        rgc.addNode(5);
        rgc.addNode(8);
        rgc.addNode(10);
        rgc.addNode(4);
        rgc.addNode(1);
        rgc.addNode(20);
        rgc.addNode(6);

        rgc.printLinkedList(head);

        System.out.println("Enter the size of chunks to reverse");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        rgc.reverseInChunks(size);

        rgc.printLinkedList(newHead);





    }



}
