class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] totalTime = new int[24*60+10];
        
        for(String s[] : book_time){
            
            int startTime = changTime(s[0]);
            int endTime = changTime(s[1]) + 10;
            
            totalTime[startTime]++;
            totalTime[endTime]--; // 청소가 끝난 시간에는 입실가능
            
        }
        
        for(int i=1; i<totalTime.length; i++){
            totalTime[i] += totalTime[i-1];
            answer = Math.max(answer, totalTime[i]);
        }
        return answer;
    }
    
    private int changTime(String s){
        
        String[] temp = s.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        
    }
}