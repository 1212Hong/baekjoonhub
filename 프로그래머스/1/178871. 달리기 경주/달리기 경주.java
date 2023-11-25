import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> maps = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            maps.put(players[i], i);
        }
        
        for(String s : callings){
            String callPlayer = s;
            int curNum = maps.get(s);
            
            String beforePlayer = players[curNum-1];
            
            players[curNum-1] = callPlayer;
            players[curNum] = beforePlayer;
            
            maps.put(callPlayer, curNum-1);
            maps.put(beforePlayer, curNum);
            
            
        }
        
        
        return players;
    }
}