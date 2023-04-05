import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, graph[][], cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 학생 수

			M = Integer.parseInt(br.readLine()); // 학생 키 비교 결과

			graph = new int[N + 1][N + 1]; // 자신보다 키가 큰 관계를 표현

			// 입력받기
			int a, b;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				graph[a][b] = 1; // 유향

			}

			int ans = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				gtDFS(k, new boolean[N + 1]);
				ltDFS(k, new boolean[N + 1]);
				if (cnt == N - 1) {
					ans++;
				}

			}
			sb.append("#").append(tc).append(" ").append(ans + "\n");
		}

		System.out.println(sb);

	}

	private static void gtDFS(int cur, boolean[] visited) {

		// cur 정점 기준으로 자신보다 큰 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (graph[cur][i] == 1 && !visited[i]) {
				cnt++;
				gtDFS(i, visited);

			}
		}

	}

	private static void ltDFS(int cur, boolean[] visited) {

		// cur 정점 기준으로 자신보다 작은 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (graph[i][cur] == 1 && !visited[i]) {
				cnt++;
				ltDFS(i, visited);
			}
		}

	}

}
