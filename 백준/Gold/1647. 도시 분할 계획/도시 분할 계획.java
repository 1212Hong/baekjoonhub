import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {

	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}

}

public class Main {

	static int N, M;
	static PriorityQueue<Edge> queue;

	static int[] parent;

	static int final_weight;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 집 개수
		M = Integer.parseInt(st.nextToken()); // 연결 간선 개수

		queue = new PriorityQueue<>();

		int A, B, C;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			queue.offer(new Edge(A, B, C));

		}

		parent = new int[N + 1];
		// makeSet
		for (int i = 1; i <= N; i++) {
			parent[i] = i;

		}

		final_weight = 0;

		int max_weight = 0;
		// 낮은 비용부터 크루스칼 진행
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();

			if (find(cur.start) != find(cur.end)) {
				union(cur.start, cur.end);
				max_weight = cur.weight;
				final_weight += cur.weight;

			}

		}

		int answer = final_weight - max_weight;
		System.out.println(answer);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return find(parent[x]);
		}
	}

}
