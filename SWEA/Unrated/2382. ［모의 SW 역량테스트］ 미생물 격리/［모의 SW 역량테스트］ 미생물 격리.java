import java.io.*;
import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class Solution {
	static int N, M, K;
	static int[][][] map;

	static int[][] maxNumber;

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	static Map<Integer, Integer> reverseMap = new HashMap<>();

	static class Point {
		int x, y, number, direct;

		public Point(int x, int y, int number, int direct) {
			super();
			this.x = x;
			this.y = y;
			this.number = number;
			this.direct = direct;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		reverseMap.put(1, 2);
		reverseMap.put(2, 1);
		reverseMap.put(3, 4);
		reverseMap.put(4, 3);

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			Deque<Point> deque = new ArrayDeque<>();

			// 입력받기
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());

				deque.add(new Point(x, y, n, m));

			}

			while (M-- > 0) {
				map = new int[N][N][2];
				maxNumber = new int[N][N]; // 각 좌표의 max 값 저장 배열
				int qSize = deque.size();
				for (int i = 0; i < qSize; i++) {
					Point current = deque.removeFirst();

					int x = current.x;
					int y = current.y;
					int numbers = current.number;
					int direct = current.direct;

					int nx = x + dx[direct];
					int ny = y + dy[direct];

					if (maxNumber[nx][ny] == 0) {// 먼저 온 미생물이 없는 경우
						maxNumber[nx][ny] = numbers;
						map[nx][ny][0] = numbers;
						map[nx][ny][1] = direct;
					} else {
						if (maxNumber[nx][ny] < numbers) {// 새로운 값이 클 경우 direct 변경
							maxNumber[nx][ny] = numbers;
							map[nx][ny][1] = direct;
						}
						map[nx][ny][0] += numbers;
					}

					// 약품 셀일 경우
					if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
						map[nx][ny][0] /= 2; // 미생물 절반으로
						direct = reverseMap.get(direct); // 방향 반대로
						map[nx][ny][1] = direct;
					}

				}

				// 다시 deque에 넣어주기
				for (int a = 0; a < N; a++) {
					for (int b = 0; b < N; b++) {
						if (map[a][b][0] != 0) {
							deque.add(new Point(a, b, map[a][b][0], map[a][b][1]));
						}
					}
				}

			}

			int answer = 0;
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					answer += map[a][b][0];
				}
			}

			sb.append("#").append(tc).append(" ").append(answer + "\n");

		}

		System.out.println(sb);

	}

}
