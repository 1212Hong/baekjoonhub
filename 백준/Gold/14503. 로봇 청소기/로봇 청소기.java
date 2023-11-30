import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, cnt;

	private static int[][] map;

	private static int[] dx = {-1, 0, 1, 0};//북, 동, 남, 서
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		washing(r, c, d);

		System.out.println(cnt);

	}

	private static void washing(int x, int y, int d) {

		if (map[x][y] == 0) {
			map[x][y] = 2; // 청소체크
			cnt++;
		}

		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int nd = (d + 3) % 4;
			int nx = x + dx[nd];
			int ny = y + dy[nd];

			if (!isIn(nx, ny)) {
				continue;
			}

			if (map[nx][ny] == 0) {
				washing(nx, ny, nd);
				flag = true;
				break;
			}

			d = (d + 3) % 4;

		}

		if (!flag) {
			int nd = (d + 2) % 4;
			int nx = x + dx[nd];
			int ny = y + dy[nd];

			if (!isIn(nx, ny)) {
				return;
			}

			if (map[nx][ny] == 1) {
				return;
			}

			washing(nx, ny, d);
		}

	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}
