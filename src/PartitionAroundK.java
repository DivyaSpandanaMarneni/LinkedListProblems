import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/13/2016.
 */
public class PartitionAroundK { //not implemented in an idea manner as two while loops are involved and will take O(n2) time
    //PartitionAroundK2

    public static Node head = null;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void printElements() {

        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
    }

    public void partition(int data) {

        Node n = head;
        Node check = null;
        Node temp = null;
        Node var = null;
        if (head == null)
            System.out.println("Nothing in the list");


        while (n != null) {
            if (n.data == data) {
                System.out.println("Partition around " + n.data);
                check = n;
                var = head;

                Node iterate =head;
                while (iterate != null) {
                    if (var.data <= check.data) {
                        var = var.next;
                        iterate = iterate.next;

                    } else {
                        temp = check;
                        check.data = var.data;
                        var.data = temp.data;
                        check = var;

                        iterate = iterate.next;


                    }

                }




            } else {
                n = n.next;
            }
        }

        //n = head;

    }

        public static void main(String[] args) throws IOException{

            PartitionAroundK pk = new PartitionAroundK();

            System.out.println("Enter the size of the list");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int size = Integer.parseInt(br.readLine());

            System.out.println("Enter the elements in the Linked list");


            int element;


            int count = 0;

            while(count <size){
                element = Integer.parseInt(br.readLine());
                pk.push(element);
                count++;
            }


            pk.printElements();

            System.out.println("Enter the element to partition around");

            int part = Integer.parseInt(br.readLine());

            pk.partition(part);

            pk.printElements();



        }

}