import java.io.*;

/**
 * Created by marne on 8/26/2016.
 */
public class StartOfLL_11 {

    public static Node head = null;
    // creation of a node and its structure
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    //method to push data into a stack
    public void push(int val){

        Node new_node = new Node(val);
        new_node.next = head;   //Time complexity = O(1) as we are inserting at the start of the list
        head = new_node;

    }
    //method to pop data from a stack
    public Node popFirst(){     // Time complexity = O(1) as we are popping at head position
        Node temp = head;
        //System.out.println("Inside pop temp node data "+temp.data);
        if(head.next == null){
            System.out.println("Last element");
            head = null;
            //System.out.println("head.next = null" + head.data);
            return temp;

        }
        if(head == null){
            System.out.println("No elements in the stack");
            return null;
        }
        if(head != null) {
            System.out.println("Currently popping " + head.data);

            head = head.next;

        }


        return temp;
    }


    public void printElements(){

        Node n = head;
        while(n!= null){
            System.out.println(n.data +"\n");   //Time complexity = O(n) as we are repeating the steps for n times i.e size of the list
            n= n.next;
        }

    }

    public  int getLength(){
        Node n = head;
        int count = 0;
        while(n!= null){
            n= n.next;
            count++;

        }
        return count;
    }


    public Node getNNode(int postion){

        System.out.println("The  asked position is " + postion);
        Node n = head;
        int count = 0;

        while(n!= null && count < postion -1){
            n= n.next;  //Time complexity is O(n)
            count++;

        }

        return  n;
    }


    public boolean containsAddress(Node check, int nodeCount){
        Node n = head;
        int count = 0;
        while(n!= null && count < nodeCount -1 ){ //executes for time 0 to current node -1 times
            if(n.equals(check))
                return true;

            n=n.next;
            count ++;
        }

        return  false;
    }


    public boolean checkCircular(){  //check only if next points to an existing node that is already traversed
        int count = 0;
        int nodeCount = 0;
        Node n = head;
        boolean circular;

        while(n != null){ // executes for times lenght of the linked list
            nodeCount++;
            circular = containsAddress(n , nodeCount); // head to node -1 size
            if(circular == true)
                count++; //total running time = n*n
            n=n.next;

            if(n == null){
                return false;
            }
        }

        if(count > 0){
            System.out.println("The list is circular");
            return true;
        }



        return false;

    }

    public boolean checkNullTermination(){

        Node n = head;
        boolean nullTerm = false;
        while(n!= null){
            n = n.next;
        }

        if(n == null){
            nullTerm = true;
        }


        return nullTerm;
    }

    public Node findHead(){

     return null;
    }

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();
        StartOfLL_11 sll = new StartOfLL_11();
        //code to get contents from a given filename
        String filename = args[0].toString();
        FileReader fileObj = new FileReader(filename);

        BufferedReader br = new BufferedReader(fileObj);
        String content = br.readLine();

        String[] words = content.split("\t");
        for (String word:words) {
            int wordVal = Integer.parseInt(word);
            sll.push(wordVal);
        }

        System.out.println("After final insertion head data :" +head.data);

        sll.printElements();


        boolean nullTerm = sll.checkNullTermination();
        System.out.println("Check null termination"+nullTerm);

        if(nullTerm == false){
            //call finding head node
            //head node is one which is the start and not pointed to by any node.
            Node start = sll.findHead();

        }

        //code to copy popped elements to a file
        File file = new File(args[1].toString());
        if(!file.exists())
            file.createNewFile();
        //FileOutputStream fos = new FileOutputStream(file)
        FileWriter fw = new FileWriter(args[1].toString(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter pw = new PrintWriter(bw);
        System.out.println("Writing the contents of the linkedlist to file");
        while(head!= null){
            Node temp = sll.popFirst();
            int popped = temp.data;
            System.out.println("Currently popped"+popped);

            bw.write(temp.data + "\t");
            //bw.write("\n");
        }
        bw.flush();
        bw.close();
        fw.close();

        System.out.println("Completed writing the contents of the linked list to a file");
        long endTime = System.currentTimeMillis();
        System.out.println("Total time for execution= " +(endTime - startTime));






    }


}
