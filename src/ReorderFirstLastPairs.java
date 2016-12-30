import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 12/15/2016.
 */

// l1->l2->l3->l4->
// l1->l4->l2->l3->

//strategy - divide the list into two using slow and fast pointers, reverse the second list and add to third list alternatively

public class ReorderFirstLastPairs {

    public static Node head= null;
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
    public void addNodeAtLast(int data){
        Node newNode = new Node(data);
        head.next = newNode;
    }

    public void printElements(Node h){
        Node node = h;
        while(node != null){
            System.out.print(node.data+"->");
            node= node.next;
        }
        System.out.println();
    }

    public Node createPairs(){
        Node sp = head;
        Node fp = head;
        Node midHead;

        Node firstEnd = null;
        while(fp.next != null && fp.next.next != null){

            sp = sp.next;
            fp = fp.next.next;

        }
        firstEnd = sp;
        midHead = sp.next;
        firstEnd.next = null;




        printElements(head);
        printElements(midHead);

        //reverse from the midHead - the second linkedlist

        Node curr = midHead.next;
        Node temp = curr.next;
        midHead.next = null;
        while(temp != null){
            curr.next = midHead;
            midHead = curr;
            curr = temp;
            temp = temp.next;

        }
        curr.next = midHead;
        midHead = curr;
        System.out.println("Elements of  second ll after reverse");
        printElements(midHead);

        //adding to new linked list the pairs

        System.out.println("Adding to new linked list");

        Node newHead = null;
        Node first = head;
        Node second = midHead;
        Node tail = null;

        while(first != null && second != null){
            if(newHead == null){
                newHead = new Node(first.data);
                tail = newHead;
                tail.next = new Node(second.data);
                tail = tail.next;

            }

            else{
                tail.next = new Node(first.data);
                tail = tail.next;
                tail.next = new Node(second.data);
                tail =tail.next;

            }



            first = first.next;
            second = second.next;
        }

        if(first  != null){
            tail.next = first;
            tail = tail.next;
        }
        if(second != null){
            tail.next = second;
            tail = tail.next;
        }
        printElements(newHead);

        return newHead;

    }

    public static void main(String[] args) throws IOException{

        System.out.println("Enter the number of elements");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ReorderFirstLastPairs reorder = new ReorderFirstLastPairs();

        int count = 0;
        System.out.println("Enter the linked list elements");
        int element;
        while(count < size){
         element =   Integer.parseInt(br.readLine());
         reorder.addNode(element);
            count++;

        }

        reorder.printElements(head);

        reorder.createPairs();

    }
}
