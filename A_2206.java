import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class A_2206 {
    private static int N,M ;
    private static int[][] matrix;

    private static int[] NEW_X= {-1,1,0,0};
    private static int[] NEW_Y= {0,0,-1,1};

    private static Queue<Points> queue = new LinkedList<>();

    private static boolean[][][] visit;
    private static int[][] counter;

    private static boolean wall;
    static class Points{
        int x;
        int y;
        boolean wall;
        public Points(int x, int y, boolean wall){
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

    }

    public static void main(String[] args)   {
        Scanner in = new Scanner(System.in);
        
        N = in.nextInt();
        M = in.nextInt();
        counter = matrix = new int[1001][1001];
        visit = new boolean[1001][1001][2];

        for(int i=0; i<N; i++){
            String str = in.next();
            for(int j=0; j<M; j++){
                matrix[i][j] = (int)str.charAt(j)-'0';
            }
        }

        
        System.out.println(bfs(0,0));

        System.out.println("-------");

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(counter[i][j] + " ");
            }
            System.out.println();
        }

        
    }
    private static int bfs(int x, int y){
        
        queue.add(new Points(x,y,false));
        visit[y][x][0] = true;
        visit[y][x][1] = true;

        while(!queue.isEmpty()){
            Points temp = queue.poll();

            if(temp.x == M-1 && temp.y==N-1){
                return counter[temp.y][temp.x]+1;
            }

            for(int i=0; i<4; i++){
                int new_x = temp.x+NEW_X[i];
                int new_y = temp.y+NEW_Y[i];

                if(new_x>=0 && new_y>=0 && new_x<M && new_y < N){
                    if(matrix[new_y][new_x]==0){
                        if(!temp.wall && !visit[new_y][new_x][0]){
                            queue.add(new Points(new_x, new_y, false));
                            visit[new_y][new_x][0] = true;
                            counter[new_y][new_x] = counter[temp.y][temp.x]+1;
                        // wall = false;
                        }else if(temp.wall && !visit[new_y][new_x][1]){
                            queue.add(new Points(new_x, new_y, true));
                            visit[new_y][new_x][1] = true;
                            counter[new_y][new_x] = counter[temp.y][temp.x]+1;
                        }
                    }else if(matrix[new_y][new_x]==1){
                        if(!temp.wall){
                            queue.add(new Points(new_x, new_y, true));
                            visit[new_y][new_x][1]=true;
                        }
                    }
                }   
            }         
        }
        return -1;
    }
}
