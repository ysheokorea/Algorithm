/*
    Owner : Developer Blog
    Title : 이분 그래프 문제
    Algorithm : BFS 알고리즘
    Date : 2022-03-23
*/

import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_1707 {

    private static int K;
    private static int V,E;
    private static NodeClass[] nodes;
    private static boolean[] visit;
    private static boolean ans;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        // 케이스 횟수 입력
        K = in.nextInt();


        int a,b;
        while(K-->0){

            
            V = in.nextInt(); // 정점의 갯수
            E = in.nextInt(); // 간선의 갯수

            nodes = new NodeClass[V+1]; // 클래스 배열
            visit = new boolean[20001]; // 정점 방문 체크 visit 배열

            for(int i=1; i<=V; i++){
                // 정점의 갯수에 맞춰 인스턴스 생성
                nodes[i] = new NodeClass(i);
            }

            // 이분 그래프 여부 체크
            ans = true;

            // 인접한 두 정점의 번호를 통해 ArrayList형 인접행렬 생성
            for(int i=0; i<E; i++){
                a = in.nextInt();
                b = in.nextInt();
    
                nodes[a].child.add(nodes[b]);
                nodes[b].child.add(nodes[a]);

            }    

            // 정점을 돌면서 이분그래프 체크
            for(int i=1; i<=V; i++){
                // 방문하지 않은 정점을 찾으면,
                if(!visit[i]){
                    // 방문 체크
                    visit[i] = true;
                    // 색상을 지정한다.
                    nodes[i].setColor(1);
                    // bfs() 메소드의 값에 따라 ans에 TRUE 혹은 FALSE 값 입력.
                    if(!bfs(i)){
                        ans = false;
                        break;
                    }
                }
            }
            // 결과값은 StringBuilder 이용
            sb.append(ans?"YES":"NO");
            sb.append("\n");

        }

        System.out.println(sb);
        
    }


    private static boolean bfs(int index){
        // NodeClass 형 queue 생성
        Queue<NodeClass> queue = new LinkedList<>();
        // 정점을 돌면서 인자값을 받아옴
        queue.add(nodes[index]);

        while(!queue.isEmpty()){
            NodeClass node = queue.poll();

            // check() 메소드가 TRUE면 "false"를 리턴한다.
            if(check(node)){
                return false;
            }else{

                // 현재 정점의 child 노드들을 순회한다.
                for(NodeClass child : node.child){
                    // child 노드를 방문하지 않았다면,
                    if(!visit[child.index]){
                        // 방문 체크
                        visit[child.index] = true;
                        // 현재 노드의 색과 반대되는 색을 child 노드에 지정한다.
                        child.setColor(1-node.nodeColor);
                        // child 노드를 queue에 push 한다.
                        queue.add(child);
                    }
                }
            }
        }


        // 모든 queue가 비게 되면 "true"를 반환한다.
        return true;
        
    }

    private static boolean check(NodeClass node){
        // 노드의 자식 노드들을 순회한다.
        for(NodeClass temp : node.child){   
            // 1. 자식 노드들을 방문했거나,
            // 2. 자식노드가 현재 노드와 동일하다면
            if(visit[temp.index] && temp.nodeColor == node.nodeColor){
                // true 를 반환한다.
                return true;
            }

        }

        // 만약 2가지 조건이 모든 자식 노드들에 해당되지 않는다면
        return false;
    }

    static class NodeClass{
        int index; // 노드의 번호
        int nodeColor; // 노드의 색상

        ArrayList<NodeClass> child = new ArrayList<>(); // 자식 노드들을 ArrayList형식으로 할당한다.

        // 생성자 메소드
        public NodeClass(int index){
            this.index = index;
        }

        // 노드 색상 지정 메소드
        public void setColor(int nodeColor){
            this.nodeColor = nodeColor;
        }
    }
}
