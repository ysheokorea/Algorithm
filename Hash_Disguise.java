import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Hash_Disguise{
    static class Solution {
        public static int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> map = new HashMap<>();

            for(int i=0; i<clothes.length; i++){
                String type = clothes[i][1];
                map.put(type, map.getOrDefault(type, 0)+1);
            }

            Iterator<Integer> it = map.values().iterator();

            while(it.hasNext()){
                int temp = it.next().intValue();
                answer *= temp + 1;
            }

            
            return answer -1 ;
        }
    }


    public static void main(String[] args){
        String[][] str = {{"yellowhat", "headgear"},{"bluesunglasses","eyewear"},{"green_turban", "headgear"}};

        int a = Solution.solution(str);

        System.out.println(a);
        
    }
}