import java.io.*;
import java.util.*;

public class Solution {

	static int test_case;

	static char[][] map;
	static int H, W, N;
	static int[] location;
	static int[] dx = { -1, 1, 0, 0 }; // 위, 아래, 좌, 우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (test_case = 1; test_case <= T; test_case++) {

			// 초기값 설정
			location = new int[2];

			// H,W 개수 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 총 이동시간
			W = Integer.parseInt(st.nextToken()); // BC의 개수

			// map 받기
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					char c = s.charAt(j);
					map[i][j] = s.charAt(j);

					// 전차의 위치 구하기
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						location[0] = i;
						location[1] = j;
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			String order = br.readLine();

			for (int i = 0; i < N; i++) {
				char c = order.charAt(i);
				if (c == 'S') {
					shoot();
				} else {
					move(c);
				}

			}

			sb.append("#" + test_case + " ");

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);

	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 && x < H && y >= 0 && y < W) {
			return true;
		}
		return false;

	}

	//
	private static void shoot() {
		int x = location[0];
		int y = location[1];
		// 전차 방향 알아내기
		char direct = map[x][y];

		// 위
		if (direct == '^') {
			for (int i = x; i >= 0; i--) {

				// 벽 일때 평지로 바꿈
				if (map[i][y] == '*') {
					map[i][y] = '.';
					break;
				}
				// 강철이면 터지고 스탑
				else if (map[i][y] == '#') {
					break;
				}
			}

		}

		// 아래
		else if (direct == 'v') {
			for (int i = x; i < H; i++) {

				// 벽 일때 평지로 바꿈
				if (map[i][y] == '*') {
					map[i][y] = '.';
					break;
				}
				// 강철이면 터지고 스탑
				else if (map[i][y] == '#') {
					break;
				}
			}

		}

		// 좌
		else if (direct == '<') {

			for (int i = y; i >= 0; i--) {

				if (map[x][i] == '*') {
					map[x][i] = '.';
					break;
				} else if (map[x][i] == '#') {
					break;
				}
			}

		}

		// 우
		else if (direct == '>') {

			for (int i = y; i < W; i++) {

				if (map[x][i] == '*') {
					map[x][i] = '.';
					break;
				} else if (map[x][i] == '#') {
					break;
				}
			}

		}

	}

	// A와 B의 각각의 좌표 기준으로 BC의 충전량 구하기
	private static void move(char order) {
		// 위

		if (order == 'U') {
			int nx = location[0] + dx[0];
			int ny = location[1] + dy[0];

			if (isIn(nx, ny) && map[nx][ny] == '.') {

				// 전차 있던 자리 . 으로 바꾸기
				map[location[0]][location[1]] = '.';

				// 전차 좌표 이동
				location[0] = nx;
				location[1] = ny;

				// 전차 방향 바꾸기
				map[nx][ny] = '^';
			} else {
				map[location[0]][location[1]] = '^';
			}
		}

		// 아래
		else if (order == 'D') {
			int nx = location[0] + dx[1];
			int ny = location[1] + dy[1];

			if (isIn(nx, ny) && map[nx][ny] == '.') {

				// 전차 있던 자리 . 으로 바꾸기
				map[location[0]][location[1]] = '.';

				// 전차 좌표 이동
				location[0] = nx;
				location[1] = ny;

				// 전차 방향 바꾸기
				map[nx][ny] = 'v';
			} else {
				map[location[0]][location[1]] = 'v';
			}

		}
		// 왼쪽
		else if (order == 'L') {
			int nx = location[0] + dx[2];
			int ny = location[1] + dy[2];

			if (isIn(nx, ny) && map[nx][ny] == '.') {

				// 전차 있던 자리 . 으로 바꾸기
				map[location[0]][location[1]] = '.';

				// 전차 좌표 이동
				location[0] = nx;
				location[1] = ny;

				// 전차 방향 바꾸기
				map[nx][ny] = '<';
			} else {
				map[location[0]][location[1]] = '<';
			}

		}
		// 오른쪽
		else if (order == 'R') {

			int nx = location[0] + dx[3];
			int ny = location[1] + dy[3];

			if (isIn(nx, ny) && map[nx][ny] == '.') {

				// 전차 있던 자리 . 으로 바꾸기
				map[location[0]][location[1]] = '.';

				// 전차 좌표 이동
				location[0] = nx;
				location[1] = ny;

				// 전차 방향 바꾸기
				map[nx][ny] = '>';
			} else {
				map[location[0]][location[1]] = '>';
			}

		}

	}

}
