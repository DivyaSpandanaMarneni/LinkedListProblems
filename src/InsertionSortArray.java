/**
 * Created by marne on 12/20/2016.
 */
public class InsertionSortArray {

    public int[] insertionSort(int[] arr){

        int i;
        int key;
        for(int j = 1;j<arr.length;j++){

            key = arr[j];
            i=j-1;

            while (i>=0 && arr[i] >= key){
                arr[i+1] =arr[i];
                i-=1;
            }//end of while

            arr[i+1] = key;
        }//end of for
        return arr;
    }


    public static void main(String[] args){
        System.out.println("Enter the numbers for insertion sort");

        int[] sortIt = {2,5,1,7,3,9};

        for (int element :
                sortIt) {
            System.out.print(element+", ");
        }

        System.out.println();

        int length = sortIt.length;

        InsertionSortArray isa = new InsertionSortArray();
        int[] op;
        op = isa.insertionSort(sortIt);

        System.out.println("Theo utput is ");

        for (int element :
                op) {
            System.out.print(element+", ");
        }

        System.out.println();


    }


}
