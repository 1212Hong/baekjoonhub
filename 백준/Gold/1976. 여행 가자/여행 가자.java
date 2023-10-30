import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i; // 초기값 설정

		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					union(i, j);
				}
			}
		}

		boolean flag = true;
		st = new StringTokenizer(br.readLine());
		int result = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (result != find(temp)) {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static int find(int num) {
		if (parent[num] == num) {
			return num;
		}

		return find(parent[num]);

	}

	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);

		if (x == y) {
			return;
		}
		if (x < y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
	}

}
