import java.io.*;
import java.util.*;

public class Main {

	static int N, M, answer;

	static char[][] map;
	static boolean[][] finished;
	static int[][] visited;

	static int[] dx = { -1, 1, 0, 0, }; // U, D, L, R
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new int[N][M];
		finished = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0) {
					dfs(i, j);

				}
			}
		}

		System.out.println(answer);

	}

	private static void dfs(int x, int y) {

		visited[x][y] = 1;
		int d;
		if (map[x][y] == 'U') {
			d = 0;
		} else if (map[x][y] == 'D') {
			d = 1;
		} else if (map[x][y] == 'L') {
			d = 2;
		} else {
			d = 3;
		}

		int nx = x + dx[d];
		int ny = y + dy[d];

		if (visited[nx][ny] == 1) {
			answer++;
		}
		if (visited[nx][ny] == 0) {
			dfs(nx, ny);
		}

		visited[x][y] = 2;
	}

}