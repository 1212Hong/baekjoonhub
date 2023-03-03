import java.io.*;
import java.util.*;

public class Main {

	private static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;

		}
	}

	static int[][] map;

	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static int babyShark = 2;
	static int shark_x, shark_y;
	static int answer;
	static int check;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 9) {
					shark_x = i;
					shark_y = j;
				}

			}
		}

		boolean flag = true;
		while (flag) {
			flag = eating();
		}

		System.out.println(answer);

	}

	// 먹을 수 있는 물고기 탐색
	private static boolean eating() {
		boolean flag = false;
		boolean[][] eat = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < babyShark && map[i][j] != 0 && map[i][j] != 9) {
					eat[i][j] = true;
					flag = true;
				}
			}
		}

		// 먹을 수 있는 물고기 한마리라도 있으면
		// 거기까지 도달할 수 있는지 탐색
		if (flag) {
			go(eat);

			if (check == babyShark) {
				babyShark++;
				check = 0;
			}
			return true;
		}

		return false;

	}

	// dfs로 길 탐색
	private static void go(boolean[][] eat) {

		int[][] distance = new int[N][N];

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (eat[i][j]) {

					boolean[][] visited = new boolean[N][N];
					visited[shark_x][shark_y] = true;

					int dis = bfs(shark_x, shark_y, i, j, visited);

					distance[i][j] = dis;
					if (dis < min && dis != 0) {
						min = dis;
					}
//					}
				}
			}
		}

		int sum = 0;
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (distance[i][j] == min) {
					answer += distance[i][j]; // 시간추가

					map[shark_x][shark_y] = 0; // 원래 위치 0

					// 상어 위치 변경
					shark_x = i;
					shark_y = j;
					map[shark_x][shark_y] = 9;

					check += 1; // 상어가 먹은 수 변경
					sum++;
					break loop;
				}
			}
		}
		if (sum == 0) {
			System.out.println(answer);
			System.exit(0);
		}

	}

	private static int bfs(int x, int y, int target_x, int target_y, boolean[][] visited) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y, 0)); // 큐에 초기값
		visited[x][y] = true;
		Point current;
		int cnt;
		while (!q.isEmpty()) {
			current = q.poll();
			x = current.x;
			y = current.y;
			cnt = current.cnt;
			if (x == target_x && y == target_y) {
				return cnt; // 이동 칸 수 반환
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (isIn(nx, ny) && (!visited[nx][ny]) && (babyShark >= map[nx][ny])) { // 상어몸무게가 지나기는길 물고기 몸무게보다 높을경우
																						// 이동
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny, cnt + 1));
				}
			}

		}

		return 0;
	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N) {
			return true;
		}
		return false;

	}

}