import java.util.Scanner;

public class A_11792 {
    public static StringBuilder result = new StringBuilder();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        
        
        System.out.println((int)(Math.pow(2, X)-1));
        recur(X, 1, 3, 2);
        System.out.println(result);

    }

    public static void recur(int count, int from, int to, int x){
        if(count <= 1){
            // System.out.println(from+" "+to);
            result.append(from+" "+to+"\n");
            return;
        }
        recur(count-1, from, x, to);
        // System.out.println(from+" "+to);
        result.append(from+" "+to+"\n");
        recur(count-1, x, to, from);
    }
}
