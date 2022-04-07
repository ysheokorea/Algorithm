/*
    Owner : Developer Blog
    Title : 특정한 최단 경로
    Algorithm : 다익스트라 알고리즘
    Date : 2022-04-05
*/


import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A_1504 {
    static class Node{
        int idx, cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static int N, E; // 정점, 간선
    public static int S1, S2;
    public static ArrayList<ArrayList<Node>> graph; // 2차원 배열 생성
    public static int[] counter;
    public static StringBuilder sb = new StringBuilder();
    public static final int INF = 200000000;

    public static int trace(int start, int end){
        // 정점 카운터 초기화
        counter = new int[801];

        // 정점 카운터에 Integer 맥스값 초기화
        for(int i=0; i<N+1; i++){
            counter[i] = Integer.MAX_VALUE;
        }
        // 우선순위 큐 생성
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        // 출발점 queue에 추가
        queue.offer(new Node(start, 0));

        // 초기 노드 counter는 0으로 초기화
        counter[start] = 0;

        while(!queue.isEmpty()){
            // 큐에서 Node 인스턴스를 추출
            Node temp = queue.poll();

            // temp.idx 정점까지 가는 cost가 작으면 해당 로직은 뛰어넘음.
            if(counter[temp.idx] < temp.cost){
                continue;
            }

            // 특정 정점까지 가기 위한 최단거리 구하는 로직
            for(int i=0; i<graph.get(temp.idx).size(); i++){
                Node nextNode = graph.get(temp.idx).get(i);
                if(counter[nextNode.idx] > temp.cost + nextNode.cost){
                    counter[nextNode.idx] = temp.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.idx, counter[nextNode.idx]));
                }
            }
        }
        return counter[end];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        E = in.nextInt();

        // 그래프 초기화 진행
        graph = new ArrayList<ArrayList<Node>>();

        // 그래프 노드 초기화
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<Node>());
        }

        // 노드의 cost와 번호로 2차원 그래프에 초기화
        for(int i=0; i<E; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            // 양방향 그래프 구현
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        // 반드시 거쳐야 하는 두개의 정점
        S1 = in.nextInt();
        S2 = in.nextInt();

        int path1 = trace(1,S1);
        int path2 = trace(S1,S2);
        int path3 = trace(S1,N);
        int path4 = trace(S2,N);
        int path5 = trace(1,S2);

        int case1 = path1+path4+path2; //4
        int case2 = path5+path3+path2; //10
        
        int ans = (case1 >= INF && case2 >= INF) ? -1 : Math.min(case1, case2);
        
        System.out.println(ans);
    }
}
