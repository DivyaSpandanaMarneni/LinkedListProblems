import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/13/2016.
 */
public class AddTwoNumbersInLL {
//TRY ADDING the numbers to the tails so that we already get a reversed list. else we have to reverse it explicitly and add the numbers
    public static Node head1 = null;
    public static Node head2 = null;

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push1(int data){
        Node node = new Node(data);
        node.next = head1;
        head1= node;

    }
    public void push2(int data){
        Node node = new Node(data);
        node.next = head2;
        head2 = node;

    }

    public void printElements(Node h){

        Node n = h;
        while(n!= null){
            System.out.println(n.data+"->");
            n = n.next;
        }

    }

    public int getNumber(Node h){

        StringBuilder sb = new StringBuilder();

        Node n = h;
        while(n != null){
            sb.append(n.data);
            n=n.next;
        }
        System.out.println("The number here is "+sb.toString());
        return  Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws IOException{


        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");

        AddTwoNumbersInLL add = new AddTwoNumbersInLL();
        ReverseLLRecursive rr = new ReverseLLRecursive();
        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            add.push1(element);
            count++;
        }

        System.out.println("Elements in list 1");
        add.printElements(head1);

        System.out.println("Reversing");
       //include the code for reversing the list

        int element2;
        count = 0;
        System.out.println("Enter the size of the linked list2");
        int size2 = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list2");

        while(count <size2){
            element2 = Integer.parseInt(br.readLine());
            add.push2(element2);
            count++;
        }

        System.out.println("Elements in list 2");
        add.printElements(head2);


        System.out.println("Getting the numbers ");

        int num1 = add.getNumber(head1);
        int num2 = add.getNumber(head2);

        int total = num1+num2;

        System.out.println("THe final result is" +total);



    }

}
