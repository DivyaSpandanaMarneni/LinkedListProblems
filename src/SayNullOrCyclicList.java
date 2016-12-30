import java.util.Hashtable;

/**
 * Created by marne on 11/5/2016.
 */


//based on the concept that two nodes have same next pointers
public class SayNullOrCyclicList {
    public static Node head;
    public Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }



    public void printElements(){

        Node node = head;

        while(node != null){
            System.out.print(node.data+"->");
            node = node.next;
        }

    }


    //using hash table where we store the address of a node and while traversing if it is repeated then it means that there is a loop

    public Node checkCycle(){
        Node node = head;

        while(node != null){
            if(ht.contains(node.data)){
                System.out.print(node.data);
                return node;

            }

            else{

                System.out.print(node.data+"->");
                ht.put(node.data,node.data);
                node = node.next;
            }
        }

        return null;


    }



    //using two step pointers

    public Node checkCycleTwoSteps(){
        Node n1 = head;
        Node n2 = head;

        while(n1 != null && n2!= null && n2.next != null){

            n1 = n1.next;
            n2 = n2.next.next;
            if(n1.equals(n2)){
                return n1;
            }

            
        }
        return null;
    }

    //find the length of the loop

    //find the nodes in the loop
    //once both the nodes meet at a point change the slow to head and and let the fast pointer be at same place
    //now increment each at same pace i.e with one step and they will meet at the start of the cycle

    public void loopNodes(Node node){
        Node n1 = head;
        Node n2 = node;
        System.out.println("Outer loop nodes");
        Node removeAt = null;
        while(n1 != null && n2!=null){

            n1 = n1.next;
            removeAt = n2;
            n2 = n2.next;


            System.out.println(n1.data+" "+n2.data);

            if(n1.equals(n2)){
                System.out.print(n1.data+"->");
                n1 = n1.next;
                while(!n1.equals(n2)) {
                    System.out.print(n1.data + "->");
                    n1 = n1.next;
                }

                removeAt.next = null;

                break;





            }

        }


    }

    //detect and remove a loop


    public static void main(String[] args){

        System.out.println("Entering the elements in the linkedlist");

        SayNullOrCyclicList cll = new SayNullOrCyclicList();

        cll.head = new Node(10);

        cll.head.next = new Node(20);


        cll.head.next.next = new Node(15);
        cll.head. next.next.next =new Node(4);

        cll.head.next.next.next.next = new Node(6);
        //creation of loop

        head.next.next.next.next.next = head.next.next;

        //Node cycleStart = cll.checkCycle();

        Node cycleNode = cll.checkCycleTwoSteps();

        System.out.println("Cycle exists " + cycleNode);

        //cll.printElements();

        System.out.println("The loop nodes are ");

        cll.loopNodes(cycleNode);

        System.out.println();

        cll.printElements();








    }


}
