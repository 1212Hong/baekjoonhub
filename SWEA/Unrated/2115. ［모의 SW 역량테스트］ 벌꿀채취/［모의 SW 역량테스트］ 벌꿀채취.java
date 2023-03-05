import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map;
	static int test_case;
	static int n, m, c;

	static int maxMoney;

	public static void main(String args[]) throws Exception {

//	System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}

			}

			int result = 0;
			int maxA = 0;
			int maxB = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {

					// 일꾼1
					maxMoney = 0;
					comb(i, j, 0, 0, 0); // x좌표, y좌표, 벌통 개수, 채취한 꿀의 양, 수익

					maxA = maxMoney;

					// 일꾼2
					maxMoney = 0;
					maxB = 0;
					// 일꾼1과 같은 행 뒷부분부터 조사
					for (int b = j + m; b <= n - m; b++) {
						comb(i, b, 0, 0, 0);
						maxB = Math.max(maxB, maxMoney);

					}

					// 일꾼1 선택 다음 행부터 조사
					for (int a = i + 1; a < n; a++) {
						for (int b = 0; b <= n - m; b++) {
							comb(a, b, 0, 0, 0);
							maxB = Math.max(maxB, maxMoney);
						}

					}

					result = Math.max(result, maxA + maxB);

				}

			}

			System.out.println("#" + test_case + " " + result);

		}

	}

	private static void comb(int x, int y, int cnt, int sum, int money) {

		// 꿀의 합이 최대 양 넘으면 return
		if (sum > c) {
			return;
		}

		if (cnt == m) {
			if (maxMoney < money) {
				maxMoney = money;
			}
			return;
		}

		comb(x, y + 1, cnt + 1, sum + map[x][y], money + map[x][y] * map[x][y]);

		comb(x, y + 1, cnt + 1, sum, money);
	}

}
