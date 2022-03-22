/*
    Owner : Developer Blog
    Title : 체스 나이트 문제
    Algorithm : BFS 알고리즘
    Date : 2022-03-22
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_7562 {

    static class Points{
        int x;
        int y;

        public Points(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int X,N;
    private static int[] startPoint;
    private static int[] endPoint;
    private static Queue<Points> queue;

    private static int[][] counter;
    private static boolean[][] visit;

    private static int[] NEW_X = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] NEW_Y = {-1, -2, -2, -1, 1, 2, 2, 1};

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        X = in.nextInt();
                
        for(int i=0; i<X; i++){

            counter = new int[301][301];
            visit = new boolean[301][301];
            startPoint= new int[2];
            endPoint = new int[2];
            queue =  new LinkedList<>();

            // 정사각형의 크기
            N = in.nextInt();

            // 시작 포인트 입력
            for(int j=0; j<2; j++){
                startPoint[j] = in.nextInt();
            }

            // 목적 포인트 입력
            for(int k=0; k<2; k++){
                endPoint[k] = in.nextInt();
            }

            System.out.println("N : "+N+" startpoint : ("+startPoint[0]+","+startPoint[1]+"), endPoint : ("+endPoint[0]+","+endPoint[1]+")");
            sb.append(bfs(startPoint[0], startPoint[1])+"\n");
            
        }
        System.out.println(sb);

        // System.out.println("=================================");
        //     for(int a=0; a<N; a++){
        //         for(int b=0; b<N; b++){
        //             System.out.print(counter[a][b]+" ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println("=================================");

    }

    private static int bfs(int x, int y){
        queue.add(new Points(x,y));
        visit[y][x] = true;

        while(!queue.isEmpty()){
            Points temp = queue.poll();

            if(temp.x==endPoint[0] && temp.y==endPoint[1]){
                return counter[endPoint[1]][endPoint[0]];
            }

            for(int i=0; i<8; i++){
                int new_X = temp.x + NEW_X[i];
                int new_Y = temp.y + NEW_Y[i];
                if(new_X>=0 && new_Y>=0 && new_X<N && new_Y<N){
                    if(!visit[new_Y][new_X]){
                        queue.add(new Points(new_X, new_Y));
                        visit[new_Y][new_X]=true;
                        counter[new_Y][new_X] = counter[temp.y][temp.x]+1;
                    }
                }
                
            }
        }

        return -1;

    }
}
