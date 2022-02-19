import java.util.ArrayList;
import java.util.Scanner;

public class Brute_force{
    public static void main(String[] args){
        Scanner inputValue =  new Scanner(System.in);

        String [] NM = inputValue.nextLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        String [] cardValueList=inputValue.nextLine().split(" ");

        ArrayList<Integer> card = new ArrayList<>();

        for(String num:cardValueList){
            card.add(Integer.parseInt(num));
        }

        int max = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for (int k=j+1; k<n; k++){
                    int sum=card.get(i)+card.get(j)+card.get(k);
                    if(sum <= m){
                        max=Math.max(sum, max);
                    }
                    if(sum==m){
                        System.out.println(max);
                        return;
                    }
                }
            }
        }

        System.out.println(n);
    }
}