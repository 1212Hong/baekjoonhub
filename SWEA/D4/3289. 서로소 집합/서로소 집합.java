import java.io.*;
import java.util.*;

public class Solution {

	static int test_case;
	static int n, m;
	static int[] parent;
	static StringBuilder sb;

	public static void main(String args[]) throws Exception {

//	System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();

			sb.append("#").append(test_case).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			// 부모 테이블에서 부모를 자기 자신으로 초기화
			for (int i = 1; i < n + 1; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st2.nextToken());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());

				// 0이면 합집합
				if (num == 0) {
					unionParent(a, b);

				}

				// 1이면 같은 집합에 포함되어있는지 확인
				else if (num == 1) {
					if (a == b) {
						sb.append(1);

					} else {
						int parentA = findParent(a);
						int parentB = findParent(b);

						// 같은 집합이면 1
						if (parentA == parentB) {
							sb.append(1);
						}
						// 아니면 0
						else {
							sb.append(0);
						}
					}
				}
			}

			System.out.println(sb);

		}

	}

	// 특정 원소가 속한 집합 찾기
	private static int findParent(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = findParent(parent[a]);
	}

	// 두 원소가 속학 집합 합치기
	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

}
