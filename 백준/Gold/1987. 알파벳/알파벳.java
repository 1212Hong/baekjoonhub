import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C; //
	static char[][] map; //
	static int answer; //

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		boolean[] alphabet = new boolean[26];
		boolean[][] visited = new boolean[R][C];

		//
		visited[0][0] = true;
		alphabet[map[0][0] - 65] = true;

		dfs(0, 0, 1, visited, alphabet);

		System.out.println(answer);

	}

	private static void dfs(int x, int y, int count, boolean[][] visited, boolean[] alphabet) {
		if (count > answer)
			answer = count;

		for (int n = 0; n < 4; n++) {
			int nx = x + dx[n];
			int ny = y + dy[n];

			if (isIn(nx, ny) && !visited[nx][ny] && !alphabet[map[nx][ny] - 65]) {

				visited[nx][ny] = true;
				alphabet[map[nx][ny] - 65] = true;
				dfs(nx, ny, count + 1, visited, alphabet);

				visited[nx][ny] = false;
				alphabet[map[nx][ny] - 65] = false;

			}
		}

	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}

}
