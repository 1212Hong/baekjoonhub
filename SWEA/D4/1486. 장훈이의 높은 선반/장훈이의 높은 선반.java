import java.io.*;
import java.util.*;

public class Solution {
	static int N, B, answer;
	static boolean[] visited;

	static ArrayList<Integer> pList;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			pList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());

			boolean flag = false;
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				if (x > B) {
					continue;
				} else if (x == B) {
					flag = true;
					sb.append("#").append(tc).append(" ").append(0).append("\n");
					break;
				} else {
					pList.add(x);
				}
			}

			if (flag) {
				continue;
			}
			int limit = pList.size();
			visited = new boolean[limit];
			Collections.sort(pList);
			answer = Integer.MAX_VALUE;
			powerSet(0, limit);

			int result = answer - B;
			sb.append("#").append(tc).append(" ").append(result + "\n");

		}
		System.out.println(sb);

	}

	private static void powerSet(int cnt, int limit) {

		if (cnt == limit) {
			int sum = 0;

			for (int i = 0; i < limit; i++) {
				if (visited[i]) {
					sum += pList.get(i);
				}

				if (sum >= answer) {
					return;
				}
			}

			if (sum >= B) {
				answer = Math.min(answer, sum);
			}
			return;

		}

		visited[cnt] = false;
		powerSet(cnt + 1, limit);

		visited[cnt] = true;
		powerSet(cnt + 1, limit);
	}

}
