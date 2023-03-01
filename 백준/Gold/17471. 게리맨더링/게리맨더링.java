import java.io.*;
import java.util.*;

public class Main {

	static int test_case;

	static int N;
	static List<Integer>[] graph;
	static boolean[] visited;
	static boolean[] group;

	static int[] pop;

	static StringBuilder sb;

	static int result = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();

		// 인구수
		pop = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[N + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st2.nextToken());
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st2.nextToken());
				graph[i].add(num);
			}
		}

		// 조합으로 선거구 뽑기
		for (int i = 1; i <= N - 1; i++) {
			comb(0, 1, 0, i);

		}
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		sb.append(result);
		System.out.println(sb);

	}

	private static void comb(int cnt, int start, int bit, int limit) {

		if (cnt == limit) {
			// 뽑은 선거구 구분
			group = new boolean[N + 1];
			for (int i = 1; i < N + 1; i++) {
				if ((bit & (1 << i)) == 0) {
					group[i] = true;
				}
			}

			// check 가 2면 2팀으로 모두 방문가능하다는 의미
			int check = 0;
			visited = new boolean[N + 1];
			for (int i = 1; i < N + 1; i++) {
				if (visited[i] == false) {
					check++;
					dfs(i);
				}
			}
			if (check == 2) {
				int diff = population();

				result = Math.min(result, diff);
			}

		}

		for (int i = start; i < N + 1; i++) {
			if ((bit & (1 << i)) != 0)
				continue;
			comb(cnt + 1, i + 1, bit | (1 << i), limit);
		}
	}

	// dfs
	private static void dfs(int from) {
		visited[from] = true;

		for (int to : graph[from]) {
			if (visited[to])
				continue;

			// 같은 그룹이라면
			if (group[from] == group[to]) {
				visited[to] = true;
				dfs(to);
			}
		}

	}

	// 인구수 차이 구하기
	private static int population() {
		int sumA = 0, sumB = 0;
		for (int i = 1; i < N + 1; i++) {
			if (group[i]) {
				sumA += pop[i];
			} else {
				sumB += pop[i];
			}
		}

		return Math.abs(sumA - sumB);

	}

}
