import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
    Owner : Developer Blog
    Title : DFS와 BFS
    Algorithm : DFS, BFS 탐색 알고리즘
    Date : 2022-03-02
*/


public class A_1260 {
    public static int[][] branch;
    public static boolean[] visit;
    public static Queue<Integer> queue;
    public static int N;
    public static int M;
    public static int V;

    public static void dfs(int start){
        visit[start] = true;
        System.out.print(start + " ");
        for(int i=1; i<=N; i++){
            if(branch[start][i]==1 && visit[i]==false){
                    dfs(i); 
            }
        }
    }
    public static void bfs(int start){
        queue = new LinkedList<Integer>();
        queue.add(start);
        visit[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i=1; i<branch.length; i++){
                if(branch[temp][i]==1 && visit[i]==false){
                    queue.add(i);
                    visit[i]=true;
                    System.out.print(i+" ");
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N=in.nextInt();
        M=in.nextInt();
        V=in.nextInt();

        branch = new int[1001][1001];
        visit = new boolean[1001];

        for(int i=0; i<M; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            branch[a][b] = branch[b][a] = 1;
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(V);


    }
    
}
