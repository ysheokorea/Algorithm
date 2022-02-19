import java.util.Scanner;
import java.util.Arrays;


public class ArrangeTest{
    public static void main(String []args){
        Scanner inputValue = new Scanner(System.in);

        int N = inputValue.nextInt();
        int[] arrInt = new int[N];

        for (int i = 0; i<N; i++){
            arrInt[i] = inputValue.nextInt();
        }
    
        for(int i=0; i<arrInt.length-1; i++){
            for(int j=i+1; j<arrInt.length; j++){
                if(arrInt[i]> arrInt[j]){
                    int temp = arrInt[j];
                    arrInt[j] = arrInt[i];
                    arrInt[i] = temp;

                }
            }
        }
        for(int num:arrInt){
            System.out.println(num);
        }
        
    }
}
