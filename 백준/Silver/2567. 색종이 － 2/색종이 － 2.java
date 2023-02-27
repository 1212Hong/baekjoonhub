import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[102][102];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x + 1; j <= x + 10; j++) {
				for (int k = y + 1; k <= y + 10; k++) {
					map[j][k] = 1;
				}
			}

		}

		int count = 0;
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx >= 0 && ny >= 0 & nx <= 101 & ny <= 101 && map[nx][ny] == 0) {
							count += 1;
						}
					}
				}
			}
		}
		System.out.println(count);

	}

}