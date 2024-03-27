import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int F, S, G, U, D;

    private static class Point{
        private int cnt, x;

        public Point(int cnt, int x) {
            this.cnt = cnt;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 F층
        S = Integer.parseInt(st.nextToken()); // 강호의 현재 위치
        G = Integer.parseInt(st.nextToken()); // 스타링크 있는 곳 위치
        U = Integer.parseInt(st.nextToken()); // 위로 U층
        D = Integer.parseInt(st.nextToken()); // 아래로 D층

        int[] dx = {+U, -D};

        int[] visited = new int[F+1];

        int answer = 0;

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, S));
        visited[S] = 1;

        if(S==G){
            System.out.println(0);
        }else {

            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int x = p.x;
                int count = p.cnt;

                if (x == G) {
                    answer = count;
                    break;
                }

                for (int m : dx) {
                    int nx = x + m;

                    if (nx < 1 || nx > F) { // 범위 설정
                        continue;
                    }

                    if (visited[nx] == 1) {
                        continue;
                    }

                    queue.add(new Point(count + 1, nx));
                    visited[nx] = 1;

                }

            }

            if(answer==0){
                System.out.println("use the stairs");
            }else{
                System.out.println(answer);
            }
        }



    }

}