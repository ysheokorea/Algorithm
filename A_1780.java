/*
    Owner : Developer Blog
    Title : 종이의개수(9개)
    Algorithm : 분할정복 알고리즘
    Date : 2022-03-02
*/

import java.util.Scanner;

public class A_1780 {
    public static int[][] arr;
    public static int firstPaper;
    public static int secondPaper;
    public static int thirdPaper;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        arr = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = in.nextInt();
            }
        }

        paperFinder(0,0,N);
        System.out.println(firstPaper);
        System.out.println(secondPaper);
        System.out.println(thirdPaper);

    }
    public static Boolean checkNumber(int row, int col, int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[row][col] != arr[i+row][j+col]) return false;
            }
        }
        return true;

    }
    public static void checkColor(int row, int col){
        switch(arr[row][col]){
            case -1:
            firstPaper++;
            break;

            case 0:
            secondPaper++;
            break;

            case 1:
            thirdPaper++;
            break;

        }

    }
    public static void paperFinder(int row, int col, int N){
        if(checkNumber(row,col,N)){
            checkColor(row, col);
        }else{
            paperFinder(row,        col,        N/3);
            paperFinder(row+N/3,    col,        N/3);
            paperFinder(row+N*2/3,  col,        N/3);
            paperFinder(row,        col+N/3,    N/3);
            paperFinder(row+N/3,    col+N/3,    N/3);
            paperFinder(row+N*2/3,  col+N/3,    N/3);
            paperFinder(row,        col+N*2/3,  N/3);
            paperFinder(row+N/3,    col+N*2/3,  N/3);
            paperFinder(row+N*2/3,  col+N*2/3,  N/3);
        }

    }
}
