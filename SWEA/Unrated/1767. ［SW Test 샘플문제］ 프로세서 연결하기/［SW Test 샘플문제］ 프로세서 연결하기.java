import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;

	static int corelimit;
	static int answer;
	static int coreMax;

	static List<Point> cores;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			cores = new ArrayList<>();

			// 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;

					if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
						continue;
					}
					if (n == 1) {
						cores.add(new Point(i, j));
					}
				}
			}

//			System.out.println(cores.size());

			corelimit = cores.size();

			coreMax = Integer.MIN_VALUE;
			answer = Integer.MAX_VALUE;

			dfs(0, 0, 0); // 프로세서 개수의 깊이, 전선 수 cnt, 전원에 연결된 프로세서 개수

			sb.append("#").append(tc).append(" ").append(answer + "\n");

		}

		System.out.println(sb);

	}

	private static void dfs(int depth, int cnt, int tempCore) {

		if (depth == corelimit) {// depth 가 limit 까지 가면 프로세서 모두 연결된 경우

			if (tempCore > coreMax) {
				answer = cnt;
				coreMax = tempCore;
			} else if (tempCore == coreMax) {
				answer = Math.min(answer, cnt);
			}
			return;
		}
		
		if(tempCore + (corelimit-depth) < coreMax && cnt>=answer) { // 가지치기 기저조건?
			return;
		}

		for (int d = 0; d < 4; d++) {
			int sumLines = isConnecting(depth, d);
			if (sumLines == -1) {// 연결 실패
				continue;

			} else {
				dfs(depth + 1, cnt + sumLines, tempCore + 1); // 성공하면 연결 프로세서 +1

				// 다시 원래대로 돌리기
				int bx = cores.get(depth).x;
				int by = cores.get(depth).y;

				while (true) {
					bx += dx[d];
					by += dy[d];
					map[bx][by] = 0;
					if (bx == 0 || by == 0 || bx == N - 1 || by == N - 1) {
						break;
					}

				}
			}

		}
		dfs(depth + 1, cnt, tempCore);

	}

	private static int isConnecting(int idx, int d) {

		List<Point> list = new ArrayList<>();

		Point current = cores.get(idx);
		int x = current.x;
		int y = current.y;

		int sum = 0;

		while (true) {

			if (x == 0 || y == 0 || x == N - 1 || y == N - 1) {
				break;
			}

			x += dx[d];
			y += dy[d];

			if (map[x][y] != 0)
				return -1;

			list.add(new Point(x, y));
			sum++;

		}

		for (Point p : list) {// 0만 만나서 while문 탈출하면 왔던 정점들 2로 바꿔준다
			map[p.x][p.y] = 2;
		}

		return sum;

	}

//	private static boolean isIn(int nx, int ny) {
//		return nx >= 0 && nx < N && ny >= 0 && ny < N;
//	}

}
