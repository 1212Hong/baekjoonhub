import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int N = elements.length;
        Set<Integer> list = new HashSet<>();
        
        // 길이 1~N까지
        for(int i=0; i<N; i++){
            for(int j=1; j<=N; j++){
                
                int cnt=1;
                int check=i;
                int temp = 0;
                
                while(cnt<=j){
                    temp += elements[check%N];
                    check++;
                    cnt++;
                }
                list.add(temp);
                
            }
        }
        
        return list.size();
    }
}