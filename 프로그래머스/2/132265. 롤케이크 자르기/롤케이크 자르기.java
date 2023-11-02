import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int N = topping.length;
        
        HashSet<Integer> setT = new HashSet<>();
        HashMap<Integer, Integer> mapT = new HashMap<>();
        
        setT.add(topping[0]);
        
        for(int i=1; i<N; i++){
            mapT.put(topping[i], mapT.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=1; i<N; i++){
            setT.add(topping[i]);
            mapT.put(topping[i], mapT.get(topping[i])-1);
            
            if(mapT.get(topping[i])==0){
                mapT.remove(topping[i]);
            }
            if(setT.size() == mapT.size()){
                answer++;
            }
        }
        return answer;
            
        }
    }
