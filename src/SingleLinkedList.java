import java.util.List;

/**
 * Created by marne on 11/5/2016.
 */
class ListNode{
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }

    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return this.data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return this.next;
    }


}


public class SingleLinkedList {

    ListNode head = null;
    private int data;
    private ListNode next;
    private int length;

    public SingleLinkedList(){
        length = 0;
    }

    public synchronized ListNode getHead(){
        return head;
    }

    //insert a node at the beginning of the head

    public void insertAtBeginning(ListNode node){
        node.setNext(head);
        head = node;
        length ++;
    }



    //insert a node at the end of the list

    public void insertAtEnd(ListNode node){
        if(head == null)
            head = node;
        else{
            ListNode p, q;

            for( p= head; (q= p.getNext()) != null; p=q){
                p.setNext(node);

            }
            length++;
        }


    }


    public void insertAtPosition(int daat, int position){

        if(position <0)
            position = 0;
        if(position > length)
            position = length;

        //if the list is empty insert it as the only element

        if(head == null) {
            head = new ListNode(data);

        }

        else if(position == 0){
            ListNode temp = new ListNode(data);
            temp.next=head;
            head = temp;
        }
        //otherwise find correct position and insert

        else{

            ListNode temp = head;
            for(int i =1; i< position;i++){

                temp = temp.getNext();
            }

            ListNode node = new ListNode(data);

            node.next = temp.getNext();
            temp.setNext(node);

        }
        length++;

    }


    //remove and return the node at the head of the list

    public ListNode removeAtHead(){
        ListNode node = head;

        if(node != null) {
            head = node.getNext();

            node.setNext(null);
        }
        return node;
    }

    //remove and return at the end of the list

    public ListNode removeAtEnd(){

        ListNode node = head;
        ListNode p= head;
        ListNode q= null;
        next = head.getNext();
        if(node == null)
            return null;
        if(next == null){
            head = null;
            return p;
        }

        while( (next = p.getNext()) != null){
            q= p;
            p = next;
        }

        q.setNext(null);
        return p;


    }

    //remove at a given position

    public void removeAtPosition(int position){

        if(position <0)
            position =0;
        if(position >=length)
            position = length -1;

        if(head == null)
            return;
        if(position == 0)
            head = head.getNext();

        //increment to the required position
        else{
            ListNode temp = head;

            for(int i=0;i<position;i++){
                temp = temp.next;


            }

            temp.setNext(temp.getNext().getNext());



        }

        length = -1;

    }


    //remove a node matching the secified node from the list

    public void removeMatched(ListNode input){
        if(head == null)
            return;
        if(head.equals(input))
            return;

        ListNode p = head, q =null;

        while( (q=p.next) != null){

            if(input.equals(q)){

                p.setNext(q.getNext());

                return;

            }

            p=q;

        }

    }


    public String toString(){

        String result ="[";

        if(head == null)
            return result+"]";

        result = result+ head.getData();

        ListNode temp = head.getNext();

        while(temp != null){

            result  = result +","+ temp.getData();
            temp = temp.getNext();

        }
        return result +"]";

    }

    //return the lenght of the list

    public int length(){
        return length;
    }

    public void clearList(){
        head = null;
        length = 0;
    }



}
