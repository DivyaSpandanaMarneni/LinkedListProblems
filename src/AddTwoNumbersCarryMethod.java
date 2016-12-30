/**
 * Created by marne on 11/4/2016.
 */
public class AddTwoNumbersCarryMethod {


    public static Node head1 = null;
    public static Node head2 = null;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data= data;
            this.next = null;
        }
    }

    public void addNode1(int data){
        Node node = new Node(data);
        node.next = head1;
        head1= node;

    }
    public void addNode2(int data){
        Node node = new Node(data);
        node.next = head2;
        head2 = node;

    }

    public void printElements(AddTwoNumbersInLL.Node h){

        AddTwoNumbersInLL.Node n = h;
        while(n!= null){
            System.out.println(n.data+"->");
            n = n.next;
        }

    }

    public int addElements(Node head1, Node head2){

        Node n1 = head1;
        Node n2 = head2;
        int carry = 0;
        String temp ;
        StringBuilder result = new StringBuilder();

        while (n1 != null && n2 != null) {

            temp = Integer.toString(n1.data + n2.data + carry);

            if (temp.length() > 1) {

                System.out.println("THe temp string is " + temp);
                System.out.println("substr "+temp.substring(0,temp.length()-1));
                carry = Integer.parseInt(temp.substring(0,temp.length()-1));

                temp = temp.substring(temp.length()-1);

            }

            result.append(temp);
            n1 = n1.next;
            n2 = n2.next;

        }

        if(n1 != null) {

            while (n1 != null) {
                if (carry > 0)
                    temp = Integer.toString(n1.data + carry);
                else
                    temp = Integer.toString(n1.data);
                n1 = n1.next;

                if (temp.length() > 1) {


                    carry = Integer.parseInt(temp.substring(0, temp.length() - 1));
                    temp = temp.substring(temp.length() - 1);

                }

                result.append(temp);

            }
        }
        if(n2 != null) {
            while (n2 != null) {
                if (carry > 0)
                    temp = Integer.toString(n2.data + carry);
                else
                    temp = Integer.toString(n2.data);
                n2 = n2.next;

                if (temp.length() > 1) {


                    carry = Integer.parseInt(temp.substring(0, temp.length() - 1));
                    temp = temp.substring(temp.length() - 1);

                }
                result.append(temp);

            }
        }




        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args){

        System.out.println("Enter the details of the two linked lists");
        AddTwoNumbersCarryMethod addN = new AddTwoNumbersCarryMethod();
        System.out.println("Adding into linkedlist1");
//        addN.addNode1(2);
//        addN.addNode1(3);
//        addN.addNode1(4);
//        addN.addNode1(5);
//        addN.addNode1(1);

        addN.addNode1(9);
        addN.addNode1(4);

        System.out.println("Adding into linkedlist2");
//        addN.addNode2(3);
//        addN.addNode2(4);
//        addN.addNode2(6);

        addN.addNode2(3);
        addN.addNode2(1);
        addN.addNode2(2);

        System.out.println("Adding the elements");

        int result = addN.addElements(head1,head2);

        System.out.println("The results is "+result);










    }


}
