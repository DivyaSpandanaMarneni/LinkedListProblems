import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/21/2016.
 */
public class SortAList {

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

    public Node sortTheList(){
        //based on selection sort. find the minimum and place in 1st node, increment the pointer
        //select the min from the remaining list and place it in the second node or the current node

        Node n = head;
        Node outN = head;
        Node nodeToReplace = head;
        int min = head.data;
        Node minNode = head;
        int temp;

        while(outN != null) {

            nodeToReplace = outN;
            min = nodeToReplace.data;
            n=nodeToReplace;
            while (n != null) {
                if (n.data < min) {
                    min = n.data;
                    minNode = n;
                }
                n = n.next;
            }

            temp = nodeToReplace.data;
            nodeToReplace.data = minNode.data;
            minNode.data = temp;

            outN = outN.next;
        }




        return head;
    }

    public static void main(String[] args) throws IOException{
        int element;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the linked list");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the Linked list");
        SortAList rd = new SortAList();



        int count = 0;

        while(count <size){
            element = Integer.parseInt(br.readLine());
            rd.push(element);
            count++;
        }

        System.out.println("Before reversing");
        rd.printElements();


        System.out.println("Sorting the list");
        Node n = rd.sortTheList();

        head = n;
        System.out.println("After sorting the list");
        rd.printElements();


    }


}
