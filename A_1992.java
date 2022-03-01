/*
    Owner : Developer Blog
    Title : 쿼드트리
    Algorithm : 분할정복 알고리즘
    Date : 2022-03-01
*/

import java.util.*;

public class A_1992 {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] quadArr;
    public static void main(String[] args){
        Scanner in =  new Scanner(System.in);
        
        int N = in.nextInt();
        
        
        quadArr = new int[N][N];

        for(int i=0; i<N; i++){
            String str = in.next();
            for(int j=0; j<N; j++){
                quadArr[i][j] = str.charAt(j)- '0';
            }
        }
        compression(0,0,N);
        System.out.println(sb);
    }
    // 숫자를 검증하는 메소드
    public static boolean checkNumber(int row, int col, int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(quadArr[row][col] != quadArr[i+row][j+col]) return false;
            }
        }
        return true;
    }
    // 숫자를 판별하는 메소드
    public static void checkColor(int row, int col){
        if(quadArr[row][col]==0){
            sb.append(0);
        }else{
            sb.append(1);
        }
    }
    // 분할정복 메소드
    public static void compression(int row, int col, int N){
        
        if(checkNumber(row, col, N)){
            checkColor(row, col);
            
        }else{
            sb.append("(");
            compression(row, col, N/2);
            compression(row, col+N/2, N/2);
            compression(row+N/2, col, N/2);
            compression(row+N/2, col+N/2, N/2);
            sb.append(")");
            
        }   
        
        return;
    }
}
