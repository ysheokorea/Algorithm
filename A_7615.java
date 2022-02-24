/*
    Owner : Developer Blog
    Title : 해싱
    Algorithm : 해시탐색 알고리즘
    Date : 2022-02-24
*/

import java.util.Scanner;

public class A_7615 {  
    public static void main(String[] args){
        // 결과값 출력을 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        // Scanner 클래스로 입력 받음
        Scanner sc = new Scanner(System.in);
        // 출력값 hashCounter 지역변수 선언
        int hashCounter;
        // t번 수행되는 회수값
        int t = sc.nextInt();
        while(t>0){
            try{
                hashCounter=0;
                // 해싱함수 정의에 필요한 변수값들 입력
                int a = sc.nextInt();
                int b = sc.nextInt();
                int x = sc.nextInt();
                int n = sc.nextInt();
                int c = sc.nextInt();
                int d = sc.nextInt();
                int m = sc.nextInt();

                // 해싱값 정의
                // c<= 해싱값 <=d 조건에 참이면 hashCounter++
                for(int j=0; j<n+1; j++){
                    int X = (a*(x+j)+b)%m;
                    if( X>= c & X<=d) hashCounter++;
                }

                sb.append(hashCounter+"\n");    
                t--;
            }catch(Exception e){
                e.getMessage();
            }
            
        }
        // 결과값 출력
        System.out.println(sb);        
    }
}
