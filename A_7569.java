/*
    Owner : Developer Blog
    Title : 토마토 문제
    Algorithm : BFS 알고리즘
    Date : 2022-03-10
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

class PointXYZ{
    int x;
    int y;
    int z;
    public PointXYZ(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;

    }
}


public class A_7569 {
    private static int M,N,H;
    private static int[][][] matrix;
    private static int[][][] counter;
    private static boolean[][][] visit;

    private static Queue<PointXYZ> queue = new LinkedList<PointXYZ>();

    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        M = in.nextInt();
        N = in.nextInt();
        H = in.nextInt();
        matrix = new int[H+1][N+1][M+1];
        counter = new int[H+1][N+1][M+1];
        visit = new boolean[H+1][N+1][M+1];
        
        
        // 배열값을 입력받는다.
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    matrix[k][i][j] = in.nextInt();
                }
            }        
        }

        

        // 최초 배열에서 1을 찾는다.
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(matrix[k][i][j]==1){
                        queue.add(new PointXYZ(j,i,k));
                        counter[k][i][j]=1;
                    }else if(matrix[k][i][j]==-1){
                        counter[k][i][j]=-1;
                    }
                }
            }
        }
        System.out.println(bfs());
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    System.out.print(counter[k][i][j]);
                }
                System.out.println();
            }
        }
        

    }

    private static int bfs(){
        int[] NEW_X = {-1,1,0,0,0,0};        
        int[] NEW_Y = {0,0,-1,1,0,0};
        int[] NEW_Z = {0,0,0,0,-1,1};

        while(!queue.isEmpty()){
            PointXYZ temp = queue.poll();

            for(int i=0; i<6; i++){
                int new_x = temp.x+NEW_X[i];
                int new_y = temp.y+NEW_Y[i];
                int new_z = temp.z+NEW_Z[i];
                if(new_x>=0 && new_y>=0 && new_z>=0 && new_x<M && new_y<N && new_z<H){
                    if(matrix[new_z][new_y][new_x]==0 && !visit[new_z][new_y][new_x]){
                        queue.add(new PointXYZ(new_x, new_y,new_z));
                        visit[new_z][new_y][new_x] = true;
                        counter[new_z][new_y][new_x] = counter[temp.z][temp.y][temp.x]+1;
                    }
                }
            }
        }
        int max = 0;
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(counter[k][i][j]==0) return -1;
                    max = Math.max(max, counter[k][i][j]);
                }
            }
        }
        return max-1;       

    }

}
