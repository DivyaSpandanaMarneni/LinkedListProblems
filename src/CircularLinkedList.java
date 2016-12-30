/**
 * Created by marne on 12/12/2016.
 */
public class CircularLinkedList {

    public static Node head = null;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //insert a node at the end of the linked list i.e., before head
    public void addNodeAtEnd(int data){
        Node newNode = new Node(data);
        newNode.next = head;

        //traverse untli node for which next is head and make its next as new node
        if(head == null)
            head = newNode;

        Node node = head.next;
        while(node.next != head){
            node = node.next;

        }
        node.next = newNode;


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

    public int findLength(){
        Node node = head;
        int count = 0;
        do{
            count++;
            node = node.next;

        }while(node != head);

        return count;

    }

    //insert a node at the front of the linked list
    //in this the new node gets updated as the head

    public void addNodeAtFront(int data){
        Node newNode = new Node(data);
        newNode.next = newNode;

        Node traverse = head.next;
        while(traverse.next != head)
            traverse = traverse.next;


        traverse.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    //delete the last node of the circular linked list

    public void deleteLast(){
        if(head == null)
            return;
        else if(head.next ==null){
            head = null;
        }
        else{
            Node node = head;
            while (node.next.next !=head){
                node = node.next;
            }
            node.next.next = null;
            node.next = head;
        }

        System.out.println("After deleting at the end");
        printElements(head);
    }

    //delete at the starting of the linked list i.e head

    public void deleteFirst(){

        Node node = head;
        while(node.next != head){
            node = node.next;
        }
        node.next = head.next;
        head.next = null;
        head= node.next;

        System.out.println("After deleting the head");
        printElements(head);

    }

    //split a circular linked list into two equal parts
    // The approach is to use the floyd cycle finding algorithm to go to the middle of the linked list and then split it
    // Also if the list is odd, assigne the extra node to the first circular linked list
    //make both the linked lists as ciruclar again

    public void splitCircular(){

        Node fp = head;
        Node sp = head;
        Node secondHead = null;

        //base case
        if(head == null)
            return;
        else if(head.next == null){
            System.out.println("Only one node is there");
            return;
        }

        while(fp.next.next != head && fp.next != head){
            sp = sp.next;
            fp = fp.next.next;
        }

        //first cll
        //if(fp.next.next == head)
          //  secondHead = sp.next;
        //else
        //    secondHead = sp;
        secondHead = sp.next;
        sp.next = head;
        System.out.println("First linked list");
        printElements(head);




        //sp becomes the head of hte second cll

        while(fp.next != head){
            fp = fp.next;
        }

        //second cll
        fp.next = secondHead;

        System.out.println("Second linked list");
        printElements(secondHead);






    }





    public static void main(String[] args){

        System.out.println("Reading the elements for linkedlist");

        CircularLinkedList cll = new CircularLinkedList();

        CircularLinkedList.head = new Node(10);
        CircularLinkedList.head.next = new Node(5);
        CircularLinkedList.head.next.next = new Node(4);
        CircularLinkedList.head.next.next.next = new Node(8);
        CircularLinkedList.head.next.next.next.next = head;

        cll.printElements(head);

        System.out.println("The length of cll is "+cll.findLength());

        System.out.println("After adding at the end");
        cll.addNodeAtEnd(6);
        cll.printElements(head);

        cll.addNodeAtFront(7);

        System.out.println("After adding at the head");
        cll.printElements(head);

        //cll.deleteLast();

        //cll.deleteFirst();

        cll.splitCircular();

    }
}
