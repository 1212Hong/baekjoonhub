import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int M, N, K;
    
    private static int[][] graph;

    private static ArrayList<Integer> scores;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    private static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int lX = Integer.parseInt(st.nextToken());
            int lY = Integer.parseInt(st.nextToken());
            int rX = Integer.parseInt(st.nextToken());
            int rY = Integer.parseInt(st.nextToken());

            marking(lX, lY, rX, rY);
        }

        int answer = 0;
        scores = new ArrayList<>();

        // 영역 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if(graph[i][j]==1){
                    continue;
                }

                answer++;

                BFS(i, j);

            }
            
        }
        Collections.sort(scores);
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");

        for (int i : scores){
            sb.append(i).append(" ");
        }

        System.out.println(sb);



    }

    private static void BFS(int startX, int startY){

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(startX, startY));

        graph[startX][startY]=1;

        int cnt = 1;

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(!isIn(nx, ny)){
                    continue;
                }

                if(graph[nx][ny]==1){
                    continue;
                }

                graph[nx][ny]=1;
                cnt++;

                queue.add(new Point(nx, ny));

            }
        }

        scores.add(cnt);

    }

    private static void marking(int lX, int lY, int rX, int rY) {
        
        for (int i = lX;  i<rX; i++){
            for (int j = lY; j < rY; j++) {
                
                graph[i][j] = 1;
                
            }
        }
    }

    private static boolean isIn(int x, int y){
        return x>=0 && y>=0 && x<N && y<M;
    }


}