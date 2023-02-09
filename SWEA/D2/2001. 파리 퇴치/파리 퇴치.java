import java.io.*;
import java.util.*;

public class Solution {

	private static int[][] arr; // 파리 배열
	private static int test_case;
	private static int n;
	private static int m; // m*m 파리채

	public static void main(String args[]) throws Exception {

//	System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new int[n][n];

			// 파리 배열
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}

			}

			int sum = 0;

			//
			// n 길이에서 m*m의 범위를 계산할만큼의 뺀 범위로 x, y 좌표 이동
			for (int x = 0; x < n - m + 1; x++) {
				for (int y = 0; y < n - m + 1; y++) {

					int temp = 0;
					//x,y 좌표 기준으로 MxM 배열 만큼의 범위의 합을 구한다
					for (int a = 0; a < m; a++) {
						for (int b = 0; b < m; b++) {
							temp += arr[x + a][y + b];
						}
					}
					if (temp > sum) {
						sum = temp;
					}
				}

			}

			System.out.println("#" + test_case + " " + sum);

		}

	}

}
