import java.util.Scanner;

// 피보나치 수열 구하기
public class A_10870 {
    public static int[] arr;
    public static int count=0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        arr = new int[N+2];
        arr[0] = 0;
        arr[1] = 1;
        fibonazzi(0,1);
        
        System.out.println(arr[N]);
        
        
        
    }

    public static int fibonazzi(int N_1, int N_2){
        if(count+2==arr.length){
            return 0;
        }
        
        int N_3 = N_1+N_2;
        arr[count+2]=N_3;
        count++;
        return fibonazzi(N_2, N_3);
    }
}
