
/*
    Owner : Developer Blog
    Title : 바이러스
    Algorithm : DFS/BFS 알고리즘
    Date : 2022-03-03
*/

import java.util.*;

public class A_2606 {
    public static int N;
    public static int M;
    public static int[][] branch;
    public static boolean[] visit;
    public static int count;
    public static Queue<Integer> queue;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        branch = new int[101][101];
        visit = new boolean[101];

        // 인접행렬 생성 
        for(int i=1; i<M+1; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            branch[a][b] = branch[b][a] = 1;
        }

        // dfs(1);
        bfs(1);
        System.out.println(count);
    }
    public static void dfs(int start){
        visit[start]=true;
        
        
        for(int j=1; j<N+1; j++){
            if(branch[start][j]==1 && visit[j]==false){
                count++;
                dfs(j);
            }
        }       
    }

    public static void bfs(int start){
        queue = new LinkedList<Integer>();

        visit[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int j=1; j<N+1; j++){
                if(branch[temp][j]==1 && visit[j]==false){
                    count++;
                    queue.add(j);
                    visit[j] = true;
                }
            }       

        }
    }
}
