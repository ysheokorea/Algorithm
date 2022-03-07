import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class A_1012 {
    public static int[][] matrix;
    public static int N,X,Y,COUNT;
    public static boolean[][] visit;
    public static int numOfBugs=0;
    public static int[] new_x = {1, -1, 0, 0};
    public static int[] new_y = {0, 0, -1, 1};
    public static ArrayList<Integer> total = new ArrayList<Integer>();
    public static Queue<Point> queue;
    


    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        // 1. 인접행렬 만들기
        // 2. DFS 알고리즘 구현
        // 3. BFS 알고리즘 구현
        Scanner in = new Scanner(System.in);
        N = in.nextInt();


        for(int k=0; k<N; k++){
            X = in.nextInt();
            Y = in.nextInt();
            matrix = new int[50][50];
            visit = new boolean[50][50];
            int COUNT = in.nextInt();
            


            for(int i=0; i<COUNT; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                matrix[b][a] = 1;
            }
            for(int i=0; i<Y; i++){
                for(int j=0; j<X; j++){
                    // System.out.print(matrix[0][1]);
                    if(matrix[i][j]==1 && !visit[i][j]){
                        numOfBugs=1;
                        bfs(j,i);
                        total.add(numOfBugs);
                    }
                }
            }
            sb.append(total.size()+"\n");
            total.clear();
        }
        System.out.println(sb);
        
    }
    // BFS
    public static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visit[y][x] = true;


        while(!queue.isEmpty()){
            Point temp = queue.poll();


            for(int i=0; i<4; i++){
                int NEW_X = temp.x+new_x[i];
                int NEW_Y = temp.y+new_y[i];    
                    // System.out.print(matrix[i][j]);
                    if(NEW_X>=0 && NEW_Y >=0 && NEW_X<X && NEW_Y<Y){
                        if(matrix[NEW_Y][NEW_X]==1 && !visit[NEW_Y][NEW_X]){                    
                            queue.add(new Point(NEW_X,NEW_Y));
                            visit[NEW_Y][NEW_X]=true;
                            numOfBugs++;
                        }
                    }
            }
        }
            
        
    }

    // DFS
    public static void dfs(int x, int y){
        visit[y][x] = true;

        for(int i=0; i<4; i++){
            int NEW_X = x+new_x[i];
            int NEW_Y = y+new_y[i];    
                // System.out.print(matrix[i][j]);
                if(NEW_X>=0 && NEW_Y >=0 && NEW_X<X && NEW_Y<Y){
                    if(matrix[NEW_Y][NEW_X]==1 && !visit[NEW_Y][NEW_X]){                    
                        dfs(NEW_X,NEW_Y);
                        numOfBugs++;
                    }
                }
        }
    }
}
