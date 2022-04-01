/*
    Owner : Developer Blog
    Title : 프로그래머스 기능 개발
    Algorithm : 스택/큐 알고리즘
    Date : 2022-04-01
*/



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Stack_1{

    static class Solution {
        public static int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            int[] completeDay = new int[100];
            int processDay = -1;
            /*
                1. 1일씩 증가하면서 작업량을 채워나간다
                2. 특정 작업이 100이 되면 Queue에 add한다.
                3. counter(=1 초기화)를 증가하면서 Queue의 요소들을 출력한다. 
            */
            
            for(int i=0; i<progresses.length; i++){
                while(progresses[i] + (speeds[i] * processDay) <100){
                    processDay++;
                }
                completeDay[processDay]++;
            }

            for(int temp : completeDay){
                if(temp != 0) {
                    queue.add(temp);
                }
            }       

            int[] answer = new int[queue.size()];
            int counter = 0;
            while(!queue.isEmpty()){
                answer[counter++] = queue.poll();
            }

            return answer;
        }
    }


    public static void main(String[] args){
        // int[] progresses = {93, 30, 55};
        // int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] answer = Solution.solution(progresses, speeds);

        for(int temp : answer){
            System.out.println(temp);
        }
        
    }
}