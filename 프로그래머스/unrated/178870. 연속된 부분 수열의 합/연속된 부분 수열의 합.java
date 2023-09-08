import java.io.*;
import java.util.*;

class Solution {
    private static int minLen;
    private static int[] answer;
    
    public int[] solution(int[] sequence, int k) {
        answer = new int[2];
        minLen = 1000000;
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = sequence.length;
        
        
        for(right=0; right<sequence.length; right++){
            sum += sequence[right];
            
            while(sum>k){
                sum -= sequence[left];
                left++;
            }
            
            if(sum==k){
                if(right-left<maxLen){
                    maxLen = right-left;
                    answer[0] = left;
                    answer[1] = right;
                }else if(right-left==maxLen){
                    answer[0] = Math.min(left, answer[0]);
                    answer[1] = Math.min(right, answer[1]);
                }
                
            }
            
        }
        return answer;
    }
    

}