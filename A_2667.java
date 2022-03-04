/*
    Owner : Developer Blog
    Title : 단지번호붙이기
    Algorithm : DFS/BFS 알고리즘
    Date : 2022-03-04
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A_2667 {
    public static int N;
    public static int[][] matrix;
    public static boolean[][] visit;
    public static ArrayList<Integer> counter;
    public static int count;
    public static int houseCounter=0;
    public static int[] X_move = {1, -1, 0, 0};
    public static int[] Y_move = {0, 0, -1, 1};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        matrix =  new int[N][N];
        visit = new boolean[N][N];
        counter = new ArrayList<>();

        for(int i=0; i<N; i++){
            String input = in.next();
            for(int j=0; j<N; j++){
                matrix[i][j] = input.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j]==1 && !visit[i][j]){
                    count=0;
                    recur(i,j);
                    counter.add(count);
                }
            }
        }
        Collections.sort(counter);
        System.out.println(counter.size());
        for(int num:counter) System.out.println(num);

    }
    
    public static void recur(int x, int y){
        
        for(int i=0; i<4; i++){
            int x_new = x+X_move[i];
            int y_new = y+Y_move[i];
            if(x_new>=0 && y_new>=0 && x_new<N && y_new<N){
                if(matrix[x_new][y_new]==1 && !visit[x_new][y_new]){
                    count++;
                    visit[x_new][y_new] = true;
                    recur(x_new, y_new);
                }
            }
        }
    }
}
