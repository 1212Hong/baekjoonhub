import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static int[] color = new int[3];
	static int[] colorRG = new int[2];
//	static boolean[][] visited;
//	static boolean[][] visited2;
	static char col;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		// 배열받기
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		boolean[][] visited = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 원래 색깔
				if (!visited[i][j]) {

					visited[i][j] = true;
					dfs(i, j, visited);
					if (map[i][j] == 'R') {
						color[0] += 1;
					} else if (map[i][j] == 'G') {
						color[1] += 1;
					} else if (map[i][j] == 'B') {
						color[2] += 1;
					}
				}
				// 적록 색맹
				if (map[i][j] == 'B') {
					if (!visited2[i][j]) {
						visited2[i][j] = true;
						dfs(i, j, visited2);
						colorRG[1] += 1;
					}
				} else {
					if (!visited2[i][j]) {
						visited2[i][j] = true;
						dfs2(i, j, visited2);
						colorRG[0] += 1;
					}
				}

			}
		}
		int sum1 = Arrays.stream(color).sum();
		int sum2 = Arrays.stream(colorRG).sum();
		sb.append(sum1).append(" ").append(sum2);
		System.out.println(sb);

	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		} else
			return false;
	}

	private static void dfs(int x, int y, boolean[][] visited) {
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (isIn(nx, ny) && !visited[nx][ny] && (map[nx][ny] == map[x][y])) {
				visited[nx][ny] = true;
				dfs(nx, ny, visited);
			}
		}
		return;

	}

	private static void dfs2(int x, int y, boolean[][] visited2) {

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (isIn(nx, ny) && !visited2[nx][ny] && (map[nx][ny] != 'B')) {
				visited2[nx][ny] = true;
				dfs2(nx, ny, visited2);
			}
		}

	}
}