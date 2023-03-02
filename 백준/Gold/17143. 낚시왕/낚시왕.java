import java.io.*;
import java.util.*;

public class Main {

	static int R, C, M;

	static int[][] sharks, map;

	static boolean[] die;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int answer = 0;

	static StringBuilder sb;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sharks = new int[M + 1][5];
		map = new int[R][C];

		die = new boolean[M + 1]; // 죽거나 잡혔는지 체크

		// 상어의 정보
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 상어 위치
			int c = Integer.parseInt(st.nextToken()); // 상어 위치
			int s = Integer.parseInt(st.nextToken()); // 상어 속력
			int d = Integer.parseInt(st.nextToken()); // d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
			int z = Integer.parseInt(st.nextToken()); // 크기

			sharks[i][0] = r - 1;
			sharks[i][1] = c - 1;
			sharks[i][2] = s;
			sharks[i][3] = d - 1;
			sharks[i][4] = z;

			map[r - 1][c - 1] = i; // 상어 1번부터 M번까지 map에 들어간다
		}

		// C초 행해진다
		for (int i = 0; i < C; i++) {

			// 낚시왕이 땅과 가장 가까운 상어 잡는다
			for (int j = 0; j < R; j++) {
				if (map[j][i] != 0) {
					int num = map[j][i]; // 상어의 번호
					answer += sharks[num][4]; // 상어 크기 더해주기
					die[num] = true; // 없는 상태
					map[j][i] = 0;
					break;
				}
			}

			// 좌표 이동 체크
			int[][] visited = new int[R][C];

			// 상어 이동시키기
			for (int k = 1; k < M + 1; k++) {

				// 상어가 살아있으면
				if (!die[k]) {
					int x = sharks[k][0];
					int y = sharks[k][1];
					int s = sharks[k][2];
					int d = sharks[k][3];

					// 기존 상어의 위치 0으로
					map[x][y] = 0;

					// 좌표 이동
					moving(d, s, x, y, k);

					// 새로운 좌표
					int move_x = sharks[k][0];
					int move_y = sharks[k][1];
					// visited 하는곳에 상어 없을 경우
					if (visited[move_x][move_y] == 0) {
						visited[move_x][move_y] = k;
					} else {
						// 원래 그 자리에 있던 상어 num
						int oldShark_num = visited[move_x][move_y];

						// 새로 이동시킬 상어가 더 클 경우
						if (sharks[oldShark_num][4] < sharks[k][4]) {
							visited[move_x][move_y] = k;
							die[oldShark_num] = true;
						} else {
							die[k] = true;
						}

					}

				}

			}

			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					// visited에 값이 있을 경우
					if (visited[j][k] != 0) {
						map[j][k] = visited[j][k];
					}

				}
			}

		}

		sb = new StringBuilder();

		sb.append(answer);
		System.out.println(sb);

	}

	private static boolean isIn(int nx, int ny) {
		if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
			return true;
		}
		return false;
	}

	// 이동 시키기
	private static void moving(int d, int s, int x, int y, int target) { // 방향, 속력

		int cnt = 0;

		while (cnt < s) {
			int nx = sharks[target][0] + dx[d];
			int ny = sharks[target][1] + dy[d];

			// 범위를 벗어나면 d 방향을 바꾼다
			if (isIn(nx, ny)) {
				if (d % 2 == 0) {// d가 0, 2일 경우
					d += 1;
				} else {
					d -= 1;
				}
				sharks[target][3] = d;
				continue;
			}
			sharks[target][0] = nx;
			sharks[target][1] = ny;
			cnt++;
		}

	}

}
