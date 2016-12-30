import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.nio.Buffer;

/**
 * Created by marne on 12/15/2016.
 */

//unlike insertion sort using arrays, we simply adjust the pointers without shifting any elements.
public class InsertionSortLL {

    public static Node head = null;
    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addNode(int data){


        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void printElements(Node n){
        Node node = n;
        Node temp = null;
        while(node != null){
            System.out.print(node.data+"->");
            temp = node;
            node= node.next;
        }

        System.out.println("Reverse links using prev");

        while(temp != null){
            System.out.print(temp.data+"<-");
            temp = temp.prev;
        }

        System.out.println();


    }

    //find min and insert it at first position
    //find second min and goes after min
    //the list to search for keeps on decreasing
    public Node insertionSort(){

        if(head == null || head.next == null)
            return head;

        Node outer = head.next;
        Node iterator = null;
        int key ;
        Node befIterator = outer;

        while (outer != null){
            key = outer.data;
            iterator = outer.prev;
            befIterator = outer;

            while (iterator != null && iterator.data >= key){
                iterator.next.data = iterator.data;
                befIterator = iterator;
                iterator = iterator.prev;
                //System.out.println("In the while loop iterator data after chaning to prev" +iterator.data);
            }


            befIterator.data = key;

            outer = outer.next;

        }

        return head;








    }

    public static void main(String[] args) throws IOException{

        System.out.println("Enter the size of hte linked list");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InsertionSortLL ill = new InsertionSortLL();
        int size = Integer.parseInt(br.readLine());

        int count = 0;

        System.out.println("Enter the elements for linked list");
        int element;
        while(count < size){
            element = Integer.parseInt(br.readLine());
            ill.addNode(element);
            count++;
        }

        ill.printElements(head);

        Node head = ill.insertionSort();

        System.out.println("After insertion  sort");

        ill.printElements(head);








    }
}
