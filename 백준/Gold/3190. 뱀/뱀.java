import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[a][b] = 1; // 사과 위치
        }

        L = Integer.parseInt(br.readLine());
        int answer = 0;
        int dir = 0;

        Deque<Spot> deque = new ArrayDeque<>();
        deque.add(new Spot(0, 0));
        map[0][0] = -1;

        Queue<Direction> queue = new ArrayDeque<>();


        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            queue.add(new Direction(X, C));
        }


        while (true) {

            Spot head = deque.getFirst();
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];
            answer++;


            if (!isIn(nx, ny)) { // 범위 밖
                break;
            }

            if (map[nx][ny] == -1) { // 자기자신 부딪힐 경우
                break;
            }

            if (map[nx][ny] == 1) { // 사과 있는 경우
                Spot cur = deque.getLast();
                map[cur.x][cur.y] = -1;

            } else if (map[nx][ny] == 0) {
                Spot cur = deque.pollLast();
                map[cur.x][cur.y] = 0;
            }
            deque.addFirst(new Spot(nx, ny));
            map[nx][ny] = -1;

            if (queue.isEmpty()) {
                continue;
            }

            if (queue.peek().time == answer) {
                Direction curDir = queue.poll();

                String C = curDir.dir;
                if (C.equals("L")) {
                    dir = (dir + 4 - 1) % 4;
                } else {
                    dir = (dir + 1) % 4;

                }
            }

        }


        System.out.println(answer);


    }


    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static class Spot {
        int x, y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Direction {
        int time;
        String dir;

        public Direction(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}

