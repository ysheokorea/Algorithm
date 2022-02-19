import java.util.Scanner;

public class A_1003 {
    public static int[] arr;
    public static int count_0=0;
    public static int count_1=0;
    public static int[][] fiboArray=new int[42][2];

    public static void main(String [] args){

        // 입력값 받는 부분
        Scanner in = new Scanner(System.in);
        // 테스트 케이스의 수
        int N = in.nextInt();
        // 테스트 케이스 N개의 array 생성 및 value 할당  
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=in.nextInt();
        }
        
        // 피보나치 입력값 초기화
        fiboArray[0][0]=1;
        fiboArray[0][1]=0;
        fiboArray[1][0]=0;
        fiboArray[1][1]=1;

        // 40 이하 자연수를 입력받았을 때 피보나치 수열 전체 연산
        for(int i=2; i<42; i++){
            fiboArray[i][0]=fiboArray[i-1][0]+fiboArray[i-2][0];
            fiboArray[i][1]=fiboArray[i-1][1]+fiboArray[i-2][1];
        }

        // 테스트 케이스의 0과 1의 값 출력
        for(int num:arr){
            System.out.println(fiboArray[num][0]+" "+fiboArray[num][1]);
        }


    }
}
