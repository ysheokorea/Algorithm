/*
    Owner : Developer Blog
    Title : 단지번호붙이기
    Algorithm : DFS/BFS 알고리즘
    Date : 2022-03-04
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class A_2667 {
    public static int N;
    public static int[][] matrix;
    public static boolean[][] visit;
    public static Queue<Point> queue;
    public static ArrayList<Integer> counter;
    public static int count;
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
                    count=1;
                    bfs(i,j);
                    counter.add(count);
                }
            }
        }
        Collections.sort(counter);
        System.out.println(counter.size());
        for(int num:counter) System.out.println(num);
    }
    // BFS
    public static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visit[x][y] = true;

        while(!queue.isEmpty()){
            Point temp = queue.poll();
            for(int i=0; i<4; i++){
                int x_new = temp.x+X_move[i];
                int y_new = temp.y+Y_move[i];
                if(x_new>=0 && y_new>=0 && x_new<N && y_new<N){
                    if(matrix[x_new][y_new]==1 && !visit[x_new][y_new]){
                        queue.add(new Point(x_new, y_new));
                        visit[x_new][y_new]=true;
                        count++;
                    }
                }
            }
        }
    }
    
    // DFS
    public static void dfs(int x, int y){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int x_new = x+X_move[i];
            int y_new = y+Y_move[i];
            if(x_new>=0 && y_new>=0 && x_new<N && y_new<N){
                if(matrix[x_new][y_new]==1 && !visit[x_new][y_new]){
                    
                    dfs(x_new, y_new);
                    count++;
                }
            }
        }
    }
}
