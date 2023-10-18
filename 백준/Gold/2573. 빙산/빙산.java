import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int cntIce, iceYear;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int[][] maps;

	private static Deque<Point> deque;

	private static class Point {
		int x, y;
		int cnt;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				maps[i][j] = temp;
				if (temp != 0) {
					cntIce++;
					deque.add(new Point(i, j));
				}
			}
		}

		iceYear = 0;
		boolean flag = false;

		// 빙산 체크해보기
		while (true) {

			checking();
			if (deque.isEmpty()) {
				break;
			}
			iceYear++;

			if (cntIce != deque.size()) { // 빙산 개수에 변화가 생기면 bfs 탐색
				flag = bfs();
				cntIce = deque.size();
			}
			if (flag) {
				break;
			}
		}
		if (flag) {
			System.out.println(iceYear);
		} else {
			System.out.println(0);
		}

	}

	private static void checking() {

		int limit = deque.size();
		int[] arr = new int[limit];

		for (int i = 0; i < limit; i++) {
			Point cur = deque.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (!isIn(nx, ny)) {
					continue;
				}
				if (maps[nx][ny] == 0) { // 해당 빙산의 주변이 0이면 -1
					cnt++;
				}
			}

			arr[i] = cnt;
			deque.add(new Point(x, y));

		}

		for (int i = 0; i < limit; i++) {
			Point cur = deque.poll();
			int x = cur.x;
			int y = cur.y;
			int temp = arr[i];
			maps[x][y] -= temp;
			if (maps[x][y] <= 0) {
				maps[x][y] = 0;
			} else {
				deque.add(new Point(x, y));
			}
		}

	}

	private static boolean bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		Point start = deque.peek();
		boolean[][] visited = new boolean[N][M];

		queue.add(start);
		int temp = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (!isIn(nx, ny)) {
					continue;
				}

				if (visited[nx][ny]) {
					continue;
				}

				if (maps[nx][ny] != 0) {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
					temp++;
				}

			}
		}

		if (temp == deque.size()) {
			return false;
		}
		return true;

	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}