/*
    Owner : Developer Blog
    Title : 숨바꼭질 문제
    Algorithm : BFS 알고리즘
    Date : 2022-03-12
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_1697 {
    private static int N,K;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int[] counter;
    private static int[] NEW_N = {-1,1,2};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();
        counter = new int[100001];

        counter[N] = 1;
        queue.add(N);
        System.out.println(bfs());

    }

    public static int bfs(){
        while(!queue.isEmpty()){
            int temp = queue.poll();

            if(temp == K) return counter[temp]-1;

            for(int i=0; i<3; i++){
                int new_n;
                if(i==2) new_n = temp * NEW_N[i];
                else new_n = temp + NEW_N[i];             
                
                if(new_n >= 0 && new_n<100000 && counter[new_n]==0){
                    queue.add(new_n);
                    counter[new_n] = counter[temp]+1;
                }
            }
            
        }
        return -1;
    }
}
