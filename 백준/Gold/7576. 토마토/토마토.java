import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int days;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new ArrayDeque<>();

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

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 1) {
                    queue.add(new Point(i, j));
                } else if (num == 0) {
                    flag = true;

                }
            }
        }
        if (!flag) {
            System.out.println(0);
        } else {
            bfs();
            boolean answer = checkTomato();
            if (answer) {
                System.out.println(days);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }

        }
        return true;
    }

    private static void bfs() {
        days = 0;
        while (!queue.isEmpty()) {


            int size = queue.size();
            Point current;

            for (int t = 0; t < size; t++) {

                current = queue.poll();
                int x = current.x;
                int y = current.y;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (!isIn(nx, ny)) {
                        continue;
                    }
                    if (map[nx][ny] == 1 || map[nx][ny] == -1) {
                        continue;
                    }

                    queue.add(new Point(nx, ny));
                    map[nx][ny] = 1;

                }

            }
            if (!queue.isEmpty()) {
                days++;
            }


        }

    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
