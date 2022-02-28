/*
    Owner : Developer Blog
    Title : 색종이 만들기
    Algorithm : 분할정복 알고리즘
    Date : 2022-02-28
*/

import java.util.*;

public class A_2630 {
    public static int[][] rectangle;
    public static int factor;
    public static int bluePaperCounter=0;
    public static int whitePaperCounter=0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        rectangle = new int[N][N];

        // 1. 입력값 Scanner 이용
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                rectangle[i][j] = in.nextInt();
            }
        }
        // 가로*세로 N 정사각형 값이 동일한지 확인
        reSize(0,0,N);      
        
        System.out.println(whitePaperCounter);
        System.out.println(bluePaperCounter);
    }
    public static void reSize(int row, int col, int N){
        if(checkColor(row, col, N)){
            paperCounter(row, col);
            return;
        }else{
            reSize(row, col, N/2);
            reSize(row+N/2, col, N/2);
            reSize(row, col+N/2, N/2);
            reSize(row+N/2, col+N/2, N/2);          
        }
    }
    public static Boolean checkColor(int row, int col, int X){
        for(int i=row; i<row+X; i++){
            for(int j=col; j<col+X; j++){
                if(rectangle[row][col]!=rectangle[i][j]) return false;
            }
        }
        return true;
    }

    public static void paperCounter(int row, int col){
        switch(rectangle[row][col]){
            case 1:
                bluePaperCounter++;
                break;
            case 0:
                whitePaperCounter++;
                break;
        }
    }    
}
