import java.util.*;

class Solution {
    
    
    private static int[] dx = {1, 0, 0, -1}; // 하, 우, 좌, 상
    private static int[] dy = {0, 1, -1, 0};
    
    private static int N, M, answer;
    
    private static boolean[] visited;
    
    private static class Point{
        
        int x, y, cnt;
        
        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
    }
    
    public int solution(int[][] maps) {
        answer = -1;
        N = maps.length;
        M = maps[0].length;
        
        maps[0][0]=0;
        BFS(0, 0, maps);
        
        return answer;
    }
    
    private static void BFS(int startX, int startY, int[][] maps){
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(startX, startY, 1));
        maps[0][0] = 0;
        
        while(!queue.isEmpty()){
            
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            
            if(x==N-1 && y==M-1){
                answer = p.cnt;
                break;
            }
        
        
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!isIn(nx, ny)){
                    continue;
                }

                if(maps[nx][ny]==0){
                    continue;
                }

                maps[nx][ny]=0;
                queue.add(new Point(nx, ny, p.cnt+1));

            }
    }
    }
    

    private static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
    
    
    
}