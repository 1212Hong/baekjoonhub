import java.io.*;
import java.util.*;

public class Main {

	static class Point {
		int x, y, cnt;
		boolean bomb;

		public Point(int x, int y, int cnt, boolean bomb) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.bomb = bomb;
		}

	}

	static int N, M;
	static char[][] map;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int answer = Integer.MAX_VALUE;

	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		bfs(0, 0);

		StringBuilder sb = new StringBuilder();

		if (answer == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(answer);

		}

		System.out.println(sb);

	}

	private static void bfs(int sx, int sy) {
		
		Queue<Point> queue = new ArrayDeque<>();
		
		boolean[][][] visited = new boolean[N][M][2];
		visited[sx][sy][0] = true; // 벽 안깼을 때 방문 체크
		visited[sx][sy][1] = true; // 벽 깼을 때 방문체크
		queue.offer(new Point(sx, sy, 1, false));

		Point current;
		int curX, curY, curCnt;
		boolean curBomb;

		while (!queue.isEmpty()) {
			current = queue.poll();
			curX = current.x;
			curY = current.y;
			curCnt = current.cnt;
			curBomb = current.bomb;

			if (curX == N-1 && curY == M-1) {
				answer = Math.min(answer, curCnt);
			}
			for (int d = 0; d < 4; d++) { // 4방탐색
				int nx = curX + dx[d];
				int ny = curY + dy[d];

				if (!isIn(nx, ny)) {
					continue;
				}

				if (curBomb == false && !visited[nx][ny][0]) {
					if (map[nx][ny] == '1') { // 벽
						queue.offer(new Point(nx, ny, curCnt + 1, true));
						visited[nx][ny][1] = true;
					} else {
						queue.offer(new Point(nx, ny, curCnt + 1, false));
						visited[nx][ny][0] = true;
					}
				} else if (curBomb == true && !visited[nx][ny][1]) {
					if (map[nx][ny] == '0') {
						queue.offer(new Point(nx, ny, curCnt + 1, true));
						visited[nx][ny][1] = true;
					}
				}

			}

		}

	}

	private static boolean isIn(int x, int y) {

		return x >= 0 && y >= 0 && x < N && y < M;
	}

}
