import java.io.*;
import java.util.*;

public class Solution {

	static int test_case;
	static int[][] BC;
	static int[] arr_A;
	static int[] arr_B;
	static int[] moveA, moveB;
	static int M, A;

	static int answer;
	static int[] dy = { 0, -1, 0, 1, 0 }; // 이동X, 상, 우, 하, 좌
	static int[] dx = { 0, 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (test_case = 1; test_case <= T; test_case++) {

			// 초기값 설정
			answer = 0;
			arr_A = new int[] { 1, 1 };
			arr_B = new int[] { 10, 10 };

			// M, A 개수 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동시간
			A = Integer.parseInt(st.nextToken()); // BC의 개수
			moveA = new int[M];
			moveB = new int[M];

			// A의 이동 정보
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st1.nextToken());
			}

			// B의 이동 정보
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st2.nextToken());
			}

			BC = new int[A][4];
			// BC의 정보 받기 A개
			for (int i = 0; i < A; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st3.nextToken());// x좌표
				BC[i][1] = Integer.parseInt(st3.nextToken());// y좌표
				BC[i][2] = Integer.parseInt(st3.nextToken());// 충전범위
				BC[i][3] = Integer.parseInt(st3.nextToken());// 성능
			}
			// 초기 위치에서 적용되나 확인
			solution(1, 1, 10, 10);

			// 각 좌표값 이동마다 확인
			for (int i = 0; i < M; i++) {
				arr_A[0] += dx[moveA[i]];
				arr_A[1] += dy[moveA[i]];

				arr_B[0] += dx[moveB[i]];
				arr_B[1] += dy[moveB[i]];

				solution(arr_A[0], arr_A[1], arr_B[0], arr_B[1]);
			}

			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb);

	}

	// A와 B의 각각의 좌표 기준으로 BC의 충전량 구하기
	private static void solution(int x_A, int y_A, int x_B, int y_B) {
		ArrayList<Integer> list_A = new ArrayList<Integer>();
		ArrayList<Integer> list_B = new ArrayList<Integer>();

		int max = 0;
		for (int i = 0; i < A; i++) {
			int BC_x = BC[i][0];
			int BC_y = BC[i][1];
			int c = BC[i][2];// 충전범위

			// 충전기 좌표와 A, B 사용자 각각의 거리 구하기
			int distance_A = Math.abs(x_A - BC_x) + Math.abs(y_A - BC_y);
			int distance_B = Math.abs(x_B - BC_x) + Math.abs(y_B - BC_y);

			// list_A 에 충족하는 충전기 index 넣기
			if (distance_A <= c) {
				list_A.add(i);
			}
			// list_B 에 충족하는 충전기 index 넣기
			if (distance_B <= c) {
				list_B.add(i);
			}

		}

		int temp = 0;

		// B가 비어있을 경우
		if (list_B.isEmpty()) {
			for (int a : list_A) {
				if (BC[a][3] > max)
					max = BC[a][3];
			}
		}
		// A가 비어있을 경우
		else if (list_A.isEmpty()) {
			for (int b : list_B) {
				if (BC[b][3] > max)
					max = BC[b][3];
			}

		} else {
			for (int a : list_A) {
				for (int b : list_B) {
					if (a == b) {
						temp = BC[a][3];
					} else {
						temp = BC[a][3] + BC[b][3];
					}

					if (temp > max) {
						max = temp;
					}
				}

			}
		}

		answer += max;
	}

}
