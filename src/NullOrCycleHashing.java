import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marne on 8/26/2016.
 */
public class NullOrCycleHashing {


    public static NullOrCycleHashing.Node head = null;
    public static Map listMap = new HashMap<Integer,Long>();
    public static int llCount = 0;
    // creation of a node and its structure
    static class Node{
        int data;
        NullOrCycleHashing.Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    //method to push data into a stack
    public void push(int val){
        llCount ++;
        NullOrCycleHashing.Node new_node = new NullOrCycleHashing.Node(val);
        new_node.next = head;   //Time complexity = O(1) as we are inserting at the start of the list
        head = new_node;
        listMap.put(llCount,head);

    }
    //method to pop data from a stack
    public Node popFirst(){     // Time complexity = O(1) as we are popping at head position
        NullOrCycleHashing.Node temp = head;
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

    public boolean checkCircularWithHash(){

        boolean circular = false;
        int traversalCount = 0;
        Node n = head;
        System.out.println("The data in head is" +n.data);
        while(n != null){
        traversalCount++;
            for(int i = 1; i<= traversalCount; i++){   // time is linear O(n)
                if( n.next != null && listMap.get(i).equals(n.next))
                    circular = true;
                else
                    return false;

            }
        }

        if(circular == true)
            return circular;

        return circular;

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
        }

        if(count > 0){
            System.out.println("The list is circular");
            return true;
        }



        return false;

    }

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();
        NullOrCycleHashing sll = new NullOrCycleHashing();
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


        //code to copy popped elements to a file
        File file = new File(args[1].toString());
        if(!file.exists())
            file.createNewFile();
        //FileOutputStream fos = new FileOutputStream(file)
        FileWriter fw = new FileWriter(args[1].toString(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter pw = new PrintWriter(bw);

        boolean circular = sll.checkCircularWithHash();
        System.out.println("Circular or not" + circular);
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
