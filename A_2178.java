/*
    Owner : Developer Blog
    Title : 미로 탐색
    Algorithm : BFS 알고리즘
    Date : 2022-03-08
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class A_2178 {
    private static int N,M;
    private static char[][] matrix;
    private static boolean[][] visit;
    private static Queue<Point> queue;
    private static int[] NEW_X = {-1,1,0,0};
    private static int[] NEW_Y = {0,0,-1,1};
    private static int[][] distance;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        matrix = new char[100][100];
        visit = new boolean[100][100];
        distance= new int[100][100];

        for(int i=0; i<N; i++){
            String str = in.next();
            for(int j=0; j<M; j++){
                matrix[i][j] = (char) (str.charAt(j));
            }
        }
        
        // distance[0][0]=1;
        bfs(0,0);
        System.out.println(distance[N-1][M-1]);  
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void bfs(int x, int y){
        visit[y][x] = true;
        distance[y][x]=1;
        queue = new LinkedList<>();
        queue.add(new Point(x,y));

        while(!queue.isEmpty()){
            Point temp = queue.poll();
            
            for(int i=0; i<4; i++){
                int new_x = temp.x+NEW_X[i];
                int new_y = temp.y+NEW_Y[i];
                if(new_x>=0 && new_y>=0 && new_x<M && new_y<N  ){
                    if(matrix[new_y][new_x]=='1' && !visit[new_y][new_x]){
                        distance[new_y][new_x]=distance[temp.y][temp.x]+1;
                        queue.add(new Point(new_x, new_y));
                        visit[new_y][new_x] = true;
                    }
                }                
            }
            
        }

    }


    private static void dfs(int x, int y){
        visit[y][x] = true;
        

        for(int i=0; i<4; i++){
            int new_x = x+NEW_X[i];
            int new_y = y+NEW_Y[i];
            if(new_x>=0 && new_y>=0 && new_x<M && new_y<N  ){
                if(matrix[new_y][new_x]=='1' && !visit[new_y][new_x]){
                    distance[new_y][new_x]=distance[y][x]+1;
                    dfs(new_x,new_y);
                    visit[y][x] = true;
                }
            }
            
        }




    }
}
