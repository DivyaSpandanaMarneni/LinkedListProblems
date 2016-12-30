import java.io.*;

/**
 * Created by marne on 8/20/2016.
 */
public class NullTerminatedOrCycle {


    public static void main(String[] args) throws IOException{
        long startTime = System.currentTimeMillis();
        StackUsingLL sll = new StackUsingLL();
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

        //System.out.println("After final insertion head data :" +head.data);

        sll.printElements();


        //code to copy popped elements to a file
        File file = new File(args[1].toString());
        if(!file.exists())
            file.createNewFile();
        //FileOutputStream fos = new FileOutputStream(file)
        FileWriter fw = new FileWriter(args[1].toString(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter pw = new PrintWriter(bw);

        //checking whether the lilnked list is circular

        boolean check = sll.checkCircular();
        if(check == true)
        System.out.println("The list  is circular");
        else
        System.out.println("The list is not circular");

        System.out.println("Writing the contents of the linkedlist to file");
        while(StackUsingLL.head!= null){
            StackUsingLL.Node temp = sll.popFirst();
            int popped = temp.data;
            //System.out.println("Currently popped"+popped);

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
