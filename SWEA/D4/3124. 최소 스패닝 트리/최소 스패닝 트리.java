import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {

	int v, weight;

	public Edge(int v, int weight) {
		super();
		this.v = v;
		this.weight = weight;
	}

	// 간선 오름차순 정렬
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}

public class Solution {

	static int test_case;

	static int V, E;
	static List<Edge>[] graph;
	static boolean[] visited;

	static PriorityQueue<Edge> pq;

	static StringBuilder sb;

	public static void main(String args[]) throws Exception {

//	System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();

			sb.append("#").append(test_case).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			pq = new PriorityQueue<>();

			graph = new ArrayList[V + 1];

			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<Edge>();

			}
			visited = new boolean[V + 1];

			for (int i = 0; i < E; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken()); // a정점
				int b = Integer.parseInt(st2.nextToken());// b정점
				int c = Integer.parseInt(st2.nextToken());// 가중치

				graph[a].add(new Edge(b, c));
				graph[b].add(new Edge(a, c));

			}

			pq.offer(new Edge(1, 0));

			long result = 0; // MST 비용

			while (!pq.isEmpty()) {
				Edge edge = pq.poll();

				// 이미 최소 신장 트리에 포함된 정점은 패스
				if (visited[edge.v])
					continue;

				// 총 가중치에 더하기
				result += edge.weight;
				visited[edge.v] = true;

				for (Edge next : graph[edge.v]) {
					if (!visited[next.v]) {
						pq.add(next);
					}
				}

			}

			sb.append(result);
			System.out.println(sb);

		}

	}

}
