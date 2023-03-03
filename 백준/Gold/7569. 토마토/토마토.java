import java.io.*;
import java.util.*;

public class Main {

	private static class Point {
		int z, x, y;

		public Point(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;

		}
	}

	static int[][][] map;

	static int M, N, H, cnt;
	static int[] dz = { 1, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Point> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로, 세로, 상자 수
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		boolean flag = false;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[k][i][j] = num;

					// 처음 입력 받을 때 익은 토마토 큐에 넣어주기
					if (num == 1) {
						q.offer(new Point(k, i, j));
					}
					// 하나라도 안익은게 있으면
					else if (num == 0) {
						flag = true;
					}
				}

			}
		}

		if (flag) {

			tomato();

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (map[i][j][k] == 0) {
							System.out.println(-1);
							System.exit(0);
						}

					}
				}
			}

			sb.append(cnt - 1); // q가 비어진 이후에 불필요하게 cnt+1 이 되는 것이므로 하나 빼준다
			System.out.println(sb);
		} else {// 다 익은 상태일 경우 0 출력
			System.out.println(0);
		}

	}

	private static void tomato() {
		cnt = 0;

		Point current;
		while (!q.isEmpty()) {

			int n = q.size();

			while (n-- > 0) {
				current = q.poll();

				int z = current.z;
				int x = current.x;
				int y = current.y;

				// z축 이동
				for (int k = 0; k < 2; k++) {
					int nz = z + dz[k];
					if (nz >= 0 && nz < H && map[nz][x][y] == 0) {
						map[nz][x][y] = 1; // 1로변경
						q.offer(new Point(nz, x, y));
					}
				}

				// x,y 사방탐색
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (isIn(nx, ny) && map[z][nx][ny] == 0) {
						map[z][nx][ny] = 1;
						q.offer(new Point(z, nx, ny));
					}

				}

			}

			cnt += 1;

		}

	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M) {
			return true;
		}
		return false;

	}

}