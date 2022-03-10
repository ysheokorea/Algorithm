/*
    Owner : Developer Blog
    Title : 토마토 문제
    Algorithm : BFS 알고리즘
    Date : 2022-03-10
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collector;
import java.awt.Point;


public class A_7576 {
    public static int N,M;
    public static int[][] matrix;
    public static boolean[][] visit;
    public static int[][] counter;
    public static int[] NEW_X = {-1,1,0,0};
    public static int[] NEW_Y = {0,0,-1,1};

    public static Queue<Point> queue ;

    public static int max;

    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);

        M = in.nextInt();
        N = in.nextInt();
        matrix = new int[1000][1000];
        counter = new int[1000][1000];
        visit = new boolean[1000][1000];
        queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == 1){
                    queue.add(new Point(j,i));
                    counter[i][j]=1;
                }else if(matrix[i][j] == -1){
                    counter[i][j]=-1;
                }
            }
        }
        System.out.println(bfs()); 
    }

    public static int bfs(){
        
        while(!queue.isEmpty()){
            Point temp = queue.poll();

            for(int i=0; i<4; i++){
                int new_x = temp.x+NEW_X[i];
                int new_y = temp.y+NEW_Y[i];
                if(new_x>=0 && new_y>=0 && new_x<M && new_y<N){
                    if(matrix[new_y][new_x]==0 && !visit[new_y][new_x]){
                        counter[new_y][new_x] = counter[temp.y][temp.x]+1;
                        queue.add(new Point(new_x, new_y));
                        visit[new_y][new_x]=true;
                    }
                }

            }
        }
        max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(max < counter[i][j]){
                    max = counter[i][j];
                }
                if(counter[i][j]==0){
                    return -1;
                }
            }
        }

        return max-1;

            
    }
}
