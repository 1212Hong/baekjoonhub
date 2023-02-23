import java.io.*;
import java.util.*;

public class Main {

	static int N, M, V;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점

		graph = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st2.nextToken());
			int end = Integer.parseInt(st2.nextToken());
			graph[start].add(end);
			graph[end].add(start);

		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(V);

		sb.append("\n");

		bfs(V);

		System.out.println(sb);

	}

	private static void dfs(int current) {

		sb.append(current).append(" ");
		visited[current] = true;

		for (int a : graph[current]) {

			if (!visited[a]) {
				dfs(a);
			}
		}

	}

	private static void bfs(int current) {
		visited = new boolean[N + 1];
		visited[current] = true;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(current);

		int start = 0;
		while (!q.isEmpty()) {
			start = q.poll();
			sb.append(start).append(" ");

			for (int b : graph[start]) {
				if (!visited[b]) {
					q.offer(b);
					visited[b] = true;
				}
			}
		}
	}

}
