import java.io.*;

import java.util.*;

public class Main {
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] graph;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 1;
        bfs(0, 0);

        System.out.println(dist[N - 1][M - 1]);


    }

    private static void bfs(int x, int y) {
        Queue<Spot> q = new ArrayDeque<>();
        q.add(new Spot(x, y));

        while (!q.isEmpty()) {
            Spot s = q.poll();
            int curX = s.x;
            int curY = s.y;

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if (!isIn(nx, ny)) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                if (graph[nx][ny] == '0') {
                    continue;
                }
                q.add(new Spot(nx, ny));
                dist[nx][ny] = dist[curX][curY] + 1;
            }

        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Spot {
        int x, y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

