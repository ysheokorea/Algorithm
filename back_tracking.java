import java.util.Scanner;

public class back_tracking {
    public static int[] arr;
    public static boolean[] isVisited;
    public static int N;
    public static int M;

    public static void main(String []args){
        Scanner in = new Scanner(System.in);

        // N과 M을 입력받는다.
        N = in.nextInt();
        M = in.nextInt();

        // M 크기의 Integer 배열 생성
        arr = new int[M];
        // N 크기의 Boolean 배멸 생성
        isVisited = new boolean[N];
    
        recur(0);
    }

    public static void recur(int depth){
        if(depth == M){
            for (int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                arr[depth] = i+1;
                recur(depth+1);
                isVisited[i] = false;
            }
        }
    }
}
