import java.io.*;
import java.util.*;

public class Solution {

	private static int test_case;

	private static int win, lose;

	private static boolean[] cards; //

	private static int[] numbers;
	private static int[] arr_A = new int[9];
	private static int[] arr_B = new int[9];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		;

		for (test_case = 1; test_case <= T; test_case++) {
			cards = new boolean[19];

			// 규영이의 카드 9가지 순서
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int n = 0; n < 9; n++) {
				int x = Integer.parseInt(st.nextToken());
				arr_A[n] = x;
				cards[x] = true;
			}

			// 인영이가 가지고 있는 카드 배열 구하기
			int start = 0;
			for (int n = 1; n < 19; n++) {
				if (!cards[n]) {
					arr_B[start] = n;
					start++;
				}
			}
			// 순열하여 뽑은 카드 넣을 배열
			numbers = new int[9];
			win = 0;
			lose = 0;
			permutation(0, 0);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose);
			System.out.println(sb);

		}

	}

	private static void permutation(int cnt, int flag) {
		if (cnt == 9) {
			int sum_a = 0;
			int sum_b = 0;
			// 인영이 숫자와 규영이 숫자 비교
			for (int j = 0; j < 9; j++) {
				// 인영이 숫자가 큰 경우
				if (numbers[j] > arr_A[j]) {
					sum_b += numbers[j] + arr_A[j];
				}
				// 규영이 숫자가 큰 경우
				else {
					sum_a += numbers[j] + arr_A[j];
				}
			}
			// sum_a 가 큰 경우 규영이가 이김
			if (sum_a > sum_b) {
				win += 1;
			} else {
				lose += 1;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}
			// 인영이가 가지고 있는 카드 순열
			numbers[cnt] = arr_B[i];
			permutation(cnt + 1, flag | (1 << i));
		}
	}

}
