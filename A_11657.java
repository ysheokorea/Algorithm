import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A_11657 {

    public static int V, E;
    public static ArrayList<ArrayList<Node>> graph;
    public static double[] counter;;
    public static PriorityQueue<Node> queue;
    

    // 정점 정보를 담은 class 생성
    static class Node{
        int idx;
        double cost;

        public Node(int idx, double cost){
            this.idx = idx;
            this.cost = cost;
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        V = in.nextInt();
        E = in.nextInt();

        graph = new ArrayList<ArrayList<Node>>();

        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<E; i++){
            int u = in.nextInt();
            int w = in.nextInt();
            double z = in.nextDouble();

            graph.get(u).add(new Node(w,z));
        }


        counter = new double[V+1];


        for(int i=0; i<V+1; i++){
            counter[i] = Integer.MAX_VALUE;
        }


        queue = new PriorityQueue<Node>((o1, o2) -> Double.compare(o1.cost, o2.cost));
        queue.offer(new Node(1,0));

        counter[1] = 0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(counter[temp.idx] < temp.cost){
                continue;
            }

            for(int i=0; i<graph.get(temp.idx).size(); i++){
                Node nextNode = graph.get(temp.idx).get(i);
                if(counter[nextNode.idx] > temp.cost + nextNode.cost){
                    counter[nextNode.idx] = temp.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.idx, counter[nextNode.idx]));
                }
            }
        }
        
        for(double temp : counter){
            System.out.println(temp+" ");
        }


        // for(int i=0; i<graph.size(); i++){
        //     for(int j=0; j<graph.get(i).size(); j++){
        //         System.out.print(graph.get(i).get(j).cost);
        //     }
        //     System.out.println();
        // }
    }
}
