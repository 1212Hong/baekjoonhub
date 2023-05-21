import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0,-1, 1};

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]==1){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }

    private static void bfs(int startX, int startY) {
        map[startX][startY]=0;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(startX, startY));

        Point current;
        while (!queue.isEmpty()){
            current = queue.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(!isIn(nx, ny)){
                    continue;
                }
                if(map[nx][ny]==0){
                    continue;
                }

                queue.add(new Point(nx, ny));
                map[nx][ny]=0;

            }

        }

    }

    private static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}
