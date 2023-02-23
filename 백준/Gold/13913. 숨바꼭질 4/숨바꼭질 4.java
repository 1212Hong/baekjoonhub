import java.io.*;
import java.util.*;

class Node {
	private int x;
	private int[] location;

	public Node(int x, int[] location) {
		this.x = x;
		this.location = location;
	}

	public int getX() {
		return this.x;
	}

	public int[] getLocation() {
		return this.location;
	}
}

public class Main {
	static int N, K;
//	static ArrayList<Integer>[] graph;
	static int[] dx = { 0, -1, 1 };
	static int[] visited;

	static int count;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		visited = new int[100001 * 2];

		bfs(N);

		System.out.println(sb);

	}

	private static boolean isIN(int x) {
		if (x >= 0 && x < 100001) {
			return true;
		}
		return false;

	}

	private static void bfs(int start) {

		Queue<Node> q = new ArrayDeque<>();
		visited[start] = 1;
		q.offer(new Node(start, new int[] { start }));

//		int x = 0;
		while (!q.isEmpty()) {

			// 한 스텝의 while 문
			// 처음 5에서 출발하여 다음 queue에는 10, 4, 6 이 들어가게 되는데 각각 count를 하면 안되고
			// 이 3개를 한 스텝으로 잡아 count + 1 을 해주어야 한다
			int size = q.size();
			while (--size >= 0) {
				Node node = q.poll();
				int x = node.getX();

				// K좌표가 되면 종료
				if (x == K) {
					sb.append(count);
					sb.append("\n");
					for (int num : node.getLocation()) {
						sb.append(num).append(" ");
					}
					return;
				}

				int[] newLocation = null;

				int nx;
				// n 인덱스 0 일 경우 => x*2 / 그 다음 -1 / 그 다음 +1
				for (int n = 0; n < 3; n++) {
					if (n == 0) {
						nx = x * 2;
						if (isIN(nx) && visited[nx] == 0) {
							newLocation = Arrays.copyOf(node.getLocation(), node.getLocation().length + 1);
							newLocation[newLocation.length - 1] = nx;
							q.offer(new Node(nx, newLocation));
							visited[nx] = 1;

						}
					} else {
						nx = x + dx[n];
						if (isIN(nx) && visited[nx] == 0) {
							newLocation = Arrays.copyOf(node.getLocation(), node.getLocation().length + 1);
							newLocation[newLocation.length - 1] = nx;
							q.offer(new Node(nx, newLocation));
							visited[nx] = 1;

						}
					}

				}
			}

			count++;
		}
	}

}
