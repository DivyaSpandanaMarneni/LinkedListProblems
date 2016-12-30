import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by marne on 10/7/2016.
 */

// Time complexity is O(n) where space complexity is O(1)
public class ReverseALL {
    public static Node head = null;

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

    public void reverse(Node n){
        head = n;
        if(head == null)
            return;
        if(head.next == null)
            return;
        Node start = head;
        Node temp = head.next;
        head.next = null;
        while(temp != null){ //complexity = O(n)

            if(head.next == temp)
                head.next = null;

            head = temp;
            //if(temp.next != null)
            temp= temp.next;
            head.next = start;
            start = head;
        }


    }

    public void printLL(){
        Node n = head;
        while(n != null){
            System.out.println(n.data+"->");
            n=n.next;

        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{

        ReverseALL rev = new ReverseALL();
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

        rev.reverse(head);

        System.out.println("After reverse");
        rev.printLL();




    }



}

