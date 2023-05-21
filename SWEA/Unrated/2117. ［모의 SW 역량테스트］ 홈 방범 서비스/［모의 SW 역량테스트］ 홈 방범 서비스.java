import java.io.*;
import java.util.*;

public class Solution {
    static int M, N;
    static int maxMoney;
    static int answer;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            int homes = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    map[i][j] = n;
                    if (n == 1) {
                        homes++;
                    }
                }
            }
            maxMoney = homes * M;
            for (int k = 1; k <= 10; k++) {

            }
            answer = 0;
            int k = 1;
            while (true) {
                int cost = k * k + (k - 1) * (k - 1);
                if (cost > maxMoney) {
                    break;
                }
                checkHome(k, cost);
                k++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");


        }
        System.out.println(sb);


    }

    private static void checkHome(int k, int cost) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(i, j, k, cost);
            }
        }

    }


    private static void bfs(int startX, int startY, int k, int cost) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(startX, startY));
        boolean[][] visited = new boolean[N][N];
        visited[startX][startY] = true;

        int cntHome = 0;
        for (int i = 1; i <= k; i++) {


            int size = queue.size();
            Point current;

            for (int t = 0; t < size; t++) {

                current = queue.poll();
                int x = current.x;
                int y = current.y;
                if (map[x][y] == 1) {
                    cntHome++;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (!isIn(nx, ny)) {
                        continue;
                    }
                    if (visited[nx][ny]) {
                        continue;
                    }

                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;

                }
            }
        }
        int tempMoney = cntHome * M - cost;

        if (tempMoney >= 0) {
            answer = Math.max(answer, cntHome);
        }


    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
