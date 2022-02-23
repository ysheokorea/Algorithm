import java.util.Arrays;
import java.util.Scanner;

/*
    Owner : Developer Blog
    Title : 이분탐색 수 찾기
    Algorithm : 이분탐색 알고리즘
*/

public class A_1920 {
    public static int arr[];
    public static StringBuilder sb = new StringBuilder();
    public static int startPoint;
    public static int endPoint;

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        // 입력값의 갯수를 입력받음
        arr = new int[N];

        // 입력 데이터를 배열에 추가함
        for(int i=0; i<N; i++){
            arr[i]=in.nextInt();
        }

        // 배열값을 정렬함
        Arrays.sort(arr);
        
        // 찾을 데이터의 갯수를 입력받음
        int M = in.nextInt();
        
        // 이분탐색 알고리즘 시작
        for(int i=0; i<M; i++){
            if(binarySearch(0, arr.length-1, in.nextInt())>=0){
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }
        }
        //
        System.out.println("\n=======================\n"+sb);
        
    }
    public static int binarySearch(int start, int end, int findValue){
        try{
            while(start<=end){
                int midPoint=(int)Math.floor((start+end)/2);
                if(arr[midPoint] > findValue){
                    end=midPoint-1;
                }
                else if(arr[midPoint] < findValue){
                    start=midPoint+1;
                }
                else{
                    return 1;
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
        return -1;
        
    }
}
