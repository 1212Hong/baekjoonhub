import java.io.*;
import java.util.*;

public class Main {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N, L, R;
	static int[][] map;
	static boolean[][] visited, sumCheck;
	static Queue<Point> q = new ArrayDeque<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int answer = 0;

	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		flag = true;
		while (flag) {
			flag = false;
			visited = new boolean[N][N];
			sumCheck = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					bfs(i, j, 0, 1);
				}
			}
            
			if (flag) { // 연합 한개라도 있을 경우 true
				answer++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answer);

		System.out.println(answer);

	}

	private static void bfs(int sx, int sy, int sum, int cnt) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(sx, sy));
		q.offer(new Point(sx, sy));
		visited[sx][sy] = true;

		Point current;
		int x, y;
		while (!queue.isEmpty()) {
			current = queue.poll();
			x = current.x;
			y = current.y;

			for (int d = 0; d < 4; d++) { // 4방탐색
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (!isIn(nx, ny))
					continue;

				if (visited[nx][ny])
					continue;

				int temp = Math.abs(map[nx][ny] - map[x][y]);

				if (temp >= L && temp <= R) { // L이상 R이하 만족할 경우

					if (!sumCheck[x][y]) { // 만족할 경우 기존 xy좌표도 sum에 더한다
						sum += map[x][y];
						sumCheck[x][y] = true;
					}
					sum += map[nx][ny]; // 연합의 인구수 합
					cnt++; // 연합이루고 있는 칸 개수 count

					queue.offer(new Point(nx, ny));
					q.offer(new Point(nx, ny));
					visited[nx][ny] = true;
					sumCheck[nx][ny] = true;
				}

			}

		}

		solution(sum, cnt);

	}
    
    private static void solution(int sum, int cnt) {

		if (q.size() == 1) { // 1개의 나라만 있을경우 만족X
			q = new ArrayDeque<>();
			return;
		}

		flag = true; // 하나라도 연합이 있는경우 flag
		int value = sum / cnt;

		Point current;
		while (!q.isEmpty()) {
			current = q.poll();
			map[current.x][current.y] = value; // 연합의 인구수로 변경
		}
	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N) {
			return true;
		}
		return false;
	}

}
