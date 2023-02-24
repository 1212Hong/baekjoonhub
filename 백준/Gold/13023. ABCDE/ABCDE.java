import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer>[] graph;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사람의 수 N
		M = Integer.parseInt(st.nextToken()); // 친구 관계의 수 M

		graph = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st2.nextToken());
			int end = Integer.parseInt(st2.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			visited[i] = true;
			dfs(i, visited, 1);

		}
		System.out.println(0);

	}

	//
	private static void dfs(int start, boolean[] visited, int count) {
		if (count == 5) {
			System.out.println(1);
			System.exit(0);
		}

		for (int num : graph[start]) {
			if (!visited[num]) {
				visited[num] = true;
				dfs(num, visited, count + 1);
				visited[num] = false;
			}
		}

	}

}