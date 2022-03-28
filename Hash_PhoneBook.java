
import java.util.HashMap;
import java.util.Map;
    

public class Hash_PhoneBook {

    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            
            // map을 구성한다.
            Map<String, Integer> map = new HashMap<>();
            
            for(int i=0; i<phone_book.length; i++){
                map.put(phone_book[i], i);
            }
            
            // phonebook을 돌면서 접두사를 잘라낸 전화번호가 존재하는지 확인한다.
            for(int i=0; i<phone_book.length; i++){           
                for(int j=0; j<phone_book[i].length(); j++){
                    if(map.containsKey(phone_book[i].substring(0,j))){
                        return false;
                    }
                }
            }
            
            return answer;
        }
    }
    public static void main(String[] args){
        
    }
}
