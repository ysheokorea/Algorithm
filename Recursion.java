import java.util.Scanner;

public class Recursion {
    public static int resultFibo = 1;
    public static void main(String [] args)    {
        Scanner in = new Scanner(System.in);

        int X = in.nextInt();
        int result = fibo(X);
        System.out.println("Fibonazzi is  : " + result);
    }

    public static int fibo(int x){
        if(x < 1){
            return resultFibo;
        }
        resultFibo *= x;
        return fibo(x-1);
    }
}
