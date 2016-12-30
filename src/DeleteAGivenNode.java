import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by marne on 10/12/2016.
 */
public class DeleteAGivenNode {

    public static Node head= null;

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
        node.next=head;
        head = node;
    }

    public void printElements(){
        Node n = head;
        while(n!= null){

            System.out.print(n.data+"->");
            n=n.next;

        }
        System.out.println();
    }

    public void deleteElement(int delete){

        Node prev  = null;// take a previous element as null and update it to the next of n if n.data = delete otherwise update it to n
        //so that prev can be used for removing a middle node and linking prev to the node after deleted node
        Node n = head;
        if(head == null )
            System.out.println("An empty list");
        else if(head.data == delete && head.next != null)
            head = head.next;
        else if(head.data == delete && head.next == null)
            head = null;


        else {

            while (n != null) {
                if(n.data == delete){
                    prev.next = n.next;
                    return;
                }

                else{
                    prev = n;
                    n=n.next;
                }


            }

        }

    }

    public static void main(String[] args) throws IOException{

        DeleteAGivenNode del = new DeleteAGivenNode();
        System.out.println("Enter the length of the list");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int list = Integer.parseInt(br.readLine());

        System.out.println("Enter the elements for the list");
        int element;
        for(int i =0;i< list;i++){

            element = Integer.parseInt(br.readLine());
            del.push(element);
        }


        del.printElements();

        System.out.println("Enter the element to be deleted");

        int delete = Integer.parseInt(br.readLine());

        del.deleteElement(delete);

        System.out.println("The elements after deleting are");

        del.printElements();



    }
}
