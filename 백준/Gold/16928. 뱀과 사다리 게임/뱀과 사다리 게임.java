import java.io.*;
import java.util.*;

public class Main {

	static class Point {
		int x, cnt;

		public Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

	}

	static int N, M, x, y, u, v;
	static int[] arr = new int[101];

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static long minThree = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 100; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x] = y;

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			arr[u] = v;

		}
		boolean[] visited = new boolean[101];

		int result = bfs(1, visited);

		sb.append(result);
		System.out.println(sb);

	}

	private static int bfs(int start, boolean[] visited) {
		Queue<Point> q = new ArrayDeque<>();
		visited[start] = true;
		q.add(new Point(start, 0));

		while (!q.isEmpty()) {
			Point current;

			current = q.poll();
			int x = current.x;
			int cnt = current.cnt;

			if (x == 100) {
				return cnt;
			}

			for (int d = 1; d <= 6; d++) {
				int nx = x + d;

				if (nx <= 100 && !visited[nx]) {
					visited[nx]=true;
					
					if(arr[nx]!=nx) {
						if(!visited[arr[nx]]) {
							q.add(new Point(arr[nx], cnt + 1));
							visited[nx]=true;
						}
					}else {
						q.add(new Point(nx, cnt+1));
					}
					
				}
	
				
			}

		}

		return 0;

	}

}
