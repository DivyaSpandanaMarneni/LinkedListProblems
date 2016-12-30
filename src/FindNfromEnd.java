/**
 * Created by marne on 8/20/2016.
 */
import java.io.*;
import java.util.Collections;

/**
 * Created by marne on 5/19/2016.
 */

//implementation of a stack using LinkedList
public class FindNfromEnd {



    public static void main(String[] args) throws IOException{

        long startTime = System.currentTimeMillis();
        StackUsingLL sll = new StackUsingLL();
        //code to get contents from a given filename
        String filename = args[0].toString();
        FileReader fileObj = new FileReader(filename);
        BufferedReader brConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(fileObj);
        String content = br.readLine();

        String[] words = content.split("\t");
        for (String word:words) {
            int wordVal = Integer.parseInt(word);
            sll.push(wordVal);
        }

        //System.out.println("After final insertion head data :" +head.data);

        sll.printElements();

        //code to find the nth element from the end of the linkedlist
        System.out.println("Enter the position");
        int n = Integer.parseInt(brConsole.readLine());
        int lengthLL = sll.getLength();
        System.out.println("The lenght of the list is " +lengthLL);

        int pos = lengthLL - n + 1;

        StackUsingLL.Node getNode = sll.getNNode(pos);
        System.out.println("The " + pos + "th element is " + getNode.data);

        //code to copy popped elements to a file
        File file = new File(args[1].toString());
        if(!file.exists())
            file.createNewFile();
        //FileOutputStream fos = new FileOutputStream(file)
        FileWriter fw = new FileWriter(args[1].toString(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter pw = new PrintWriter(bw);




        System.out.println("Writing the contents of the linkedlist to file");
        while(StackUsingLL.head!= null){
            StackUsingLL.Node temp = sll.popFirst();
            int popped = temp.data;
            //System.out.println("Currently popped"+popped);

            bw.write(temp.data + "\t");
            //bw.write("\n");
        }

        System.out.println("The elements after popping are :");
        sll.printElements();
        bw.flush();
        bw.close();
        fw.close();

        System.out.println("Completed writing the contents of the linked list to a file");
        long endTime = System.currentTimeMillis();
        System.out.println("Total time for execution= " +(endTime - startTime));






    }


}
