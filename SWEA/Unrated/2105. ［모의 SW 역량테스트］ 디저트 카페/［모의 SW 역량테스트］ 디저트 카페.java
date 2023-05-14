import java.io.*;
import java.util.*;

public class Solution {

	static int N, answer;
	static int startX, startY;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] checked;

	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

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
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					checked = new boolean[101];
					visited[i][j] = true;
					checked[map[i][j]] = true;
					startX = i;
					startY = j;
					dfs(i, j, 1, 0);

				}

			}
			if (answer == Integer.MIN_VALUE) {
				answer = -1;
			}
			sb.append('#').append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int cnt, int direct) {

		for (int i = direct; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isIn(nx, ny)) {
				continue;
			}

			if (nx == startX && ny == startY && cnt >= 4) {
				answer = Math.max(answer, cnt);
				continue;
			}

			if (checked[map[nx][ny]]) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}

			visited[nx][ny] = true;
			checked[map[nx][ny]] = true;
			cnt++;
			dfs(nx, ny, cnt, i);
			cnt--;
			visited[nx][ny] = false;
			checked[map[nx][ny]] = false;

		}

	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}