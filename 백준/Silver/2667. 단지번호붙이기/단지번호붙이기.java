import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int M, N, K;
    
    private static int[][] graph;

    private static ArrayList<Integer> houses;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        houses = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {

                graph[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));

            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(!isIn(i, j)){
                    continue;
                }

                if(graph[i][j]!=1){
                    continue;
                }

                BFS(i, j);

            }
        }
        Collections.sort(houses);

        System.out.println(houses.size());
        for (int h : houses){
            System.out.println(h);
        }


    }

    private static void BFS(int sX, int sY) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(sX, sY));
        int cnt = 0;
        graph[sX][sY]=0;
        cnt++;


        while (!queue.isEmpty()){
            Point curP = queue.poll();
            int curX = curP.x;
            int curY = curP.y;

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(!isIn(nx, ny)){
                    continue;
                }
                if(graph[nx][ny]!=1){
                    continue;
                }

                queue.add(new Point(nx, ny));
                cnt++;
                graph[nx][ny]=0;

            }
        }

        houses.add(cnt);
    }

    private static boolean isIn(int x, int y){

        return x>=0 && x<N && y>=0 && y<N;
    }



}