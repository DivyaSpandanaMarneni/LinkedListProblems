import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by marne on 10/15/2016.
 */
public class CheckPalindromeLL {

    //reverse the linkedlist, comapre each element in the reverse with the original
    //second strategy - slow and fast pointers
    public static Node head = null;
    public static Node midHead = null;
    public Stack<Integer> stack = new Stack<Integer>();
    public static int globalListCount = 0;
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public void push(int data){

        Node n = new Node(data);
        n.next = head;
        head =n ;
    }

    public void printElements(){

        Node n = head;
        while(n!= null){
            System.out.print(n.data+"->");
            n=n.next;
        }
    }

    public void getElementsForComparing(){

        //maintain a count pointer to check if the list length is even or odd
        int count = 0;
        Node node = head;
        Node node2 = head;
    System.out.println("The global count is "+globalListCount);
        while(node2.next!= null && node2 != null && node2.next.next != null){
            stack.push(node.data);
            node = node.next;
            node2=node2.next.next;
            count ++;
            System.out.println("The count in while "+count);
        }
        System.out.println("The size of the stack is "+stack.size());

        if(node2!= null && globalListCount%2 == 0) {
            System.out.println("Entered into if ");
            stack.push(node.data);
            node = node.next;
        }
        else {
            System.out.println("Checking for odd if it went into else");
            node = node.next;
        }
        midHead = node;

        System.out.println("The size of the stack is "+stack.size());



    }

    public static void main(String[] args) throws IOException{

        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");
        //RemoveDupsNoHT rd = new RemoveDupsNoHT();
        CheckPalindromeLL pal = new CheckPalindromeLL();



        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            pal.push(element);
            globalListCount++;
            count++;
        }


        pal.printElements();

        pal.getElementsForComparing();



        while(midHead!= null && !pal.stack.empty()){

            if(midHead.data == pal.stack.pop()){
                System.out.println(midHead.data +" verified and into palindrome sequence");
                System.out.println(midHead.data +"->");
                midHead = midHead.next;


            }

            else {
                System.out.println("Not a palindrome");
                midHead = midHead.next;
                //n2 = n2.next;
            }
        }


        System.out.println("Over comparing");
    }




}
