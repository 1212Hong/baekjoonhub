import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;
        for(int[] c : commands){
            
            int start = c[0]-1;
            int end = c[1]-1;
            int target = c[2]-1;
            
            if(start==end){
                answer[cnt] = array[start];
                cnt++;
                continue;
            }else{
                int[] newArr = new int[end-start+1];
                int temp = 0;
                for(int j=start; j<=end; j++){
                    newArr[temp] = array[j];
                    temp++;
                }
                Arrays.sort(newArr);
                answer[cnt] = newArr[target];
                cnt++;
            }
        }
        
        
        return answer;
    }
}