import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by marne on 10/8/2016.
 */
public class ReverseLLRecursive {

    public static Node head = null;
    Node start = null;
    Node temp = null;

    //creation of node and its structure
    class Node{
        //properties of this class
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    public Node reverse(Node curr,Node prev){ // tail recursion

       // Node currentHead = current;
        if(curr == null) // what is the reverse when the list is empty
            return null;
        if(curr.next == null) { // what is the reverse when the list has only one element
            head = curr;

            //update the link from curr to prev
            curr.next = prev;
            return head;
        }
        //newCurr for recursive call
        Node newCurr = curr.next;

        //update next of curr to prev
        curr.next = prev;
        reverse(newCurr,curr);
        return head;
    }

    public void printLL(){
        Node n = head;
        while(n != null){
            System.out.println(n.data+"->");
            n=n.next;

        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ReverseLLRecursive rev = new ReverseLLRecursive();
        String filename = args[0].toString();

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String content = br.readLine();
        int value;
        String[] contents = content.split("\t");
        for (String number :
                contents) {
            value = Integer.parseInt(number);
            rev.push(value);
        }


        rev.printLL();

        head = rev.reverse(head,null);

        System.out.println("After reverse");
        rev.printLL();




    }




}
