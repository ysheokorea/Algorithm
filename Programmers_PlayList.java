import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Programmers_PlayList {
    static class Solution {

        public static int[] solution(String[] genres, int[] plays) {
            /*
                1. genre(노래의 장르)와 play(노래별 재생 횟수) 맵을 만든다.
                2. 조건확인
                    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
                    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
                    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                3. plays를 기준으로 genres들을 합한 새로운 맵을 만든다.
                4. 새로운 맵을 Iterator로 출력한다.

            */
            Map<String, Integer> genre_map = new HashMap<>();          
            ArrayList<String> genre_arr = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();


            for(int i=0; i<genres.length; i++){
                genre_map.put(genres[i], genre_map.getOrDefault(genres[i], 0)+plays[i]);
            }

            // genre_map의 키값을 추출해서 ArrayList에 담는다.
            for(String temp : genre_map.keySet()){
                genre_arr.add(temp);
            }

            // 내림차순 정렬
            Collections.sort(genre_arr, (o1, o2) -> genre_map.get(o2) - genre_map.get(o1));

            // 해당 장르의 play 횟수가 큰 장르의 인덱스를 찾는다.
            for(int i=0; i<genre_arr.size(); i++){
                String temp_str = genre_arr.get(i);

                // 장르에서 첫번째로 재생수가 많은 장르를 찾는다.
                int max_value = 0;
                int first_idx = -1;
                for(int j=0; j<genres.length; j++){
                    if(temp_str.equals(genres[j]) && max_value < plays[j]){
                        max_value = plays[j];
                        first_idx = j;
                    }
                }
                
                // 장르에서 두번째로 재생수가 많은 장르를 찾는다.
                max_value = 0;
                int second_idx = -1;
                for(int j=0; j<genres.length; j++){
                    if(temp_str.equals(genres[j]) && max_value < plays[j] && j!=first_idx){
                        max_value = plays[j];
                        second_idx = j;
                    }
                }
                result.add(first_idx);
                if(second_idx >= 0){
                    result.add(second_idx);
                }

            }

            // return을 위해 int형 배열로 변환해준다.
            int[] answer = new int[result.size()];
            for(int i=0; i<result.size(); i++){
                answer[i] = result.get(i);
            }
            return answer;
        }
    }

    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = Solution.solution(genres, plays);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
        
    }
}
