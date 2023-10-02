import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2)->
            o1[1]-o2[1]
        );
        int end = targets[0][1];
        
        for(int i=1; i<targets.length; i++){
            int tempL = targets[i][0];
            if(tempL>=end){
                end = targets[i][1];
                answer++;
            }
            
    
        }
        return answer;
    }
}