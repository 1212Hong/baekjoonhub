import java.io.*;
import java.util.*;

public class Main {
	static int n; // 카드 개수
	static int m; // m을 넘지 않는 점수
	static int[] arr; // 구간합
	static int[] numbers;

	static int score;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 카드 개수
		m = Integer.parseInt(st.nextToken()); // m을 넘지 않는 점수

		arr = new int[n];

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		comb(0, 0, 0, 0);

		StringBuilder sb = new StringBuilder();
		sb.append(answer);

		System.out.println(sb);
	}

	private static void comb(int cnt, int flag, int start, int score) {
		if (cnt == 3) {
			// score가 m과 같을 경우 m 출력하고 전체 종료
			if (score == m) {
				System.out.println(m);
				System.exit(0);
			} 
			//m보다 작고 score가 answer보다 클 경우 갱신
			else if (score < m) {
				if (score > answer) {
					answer = score;
				}

			}
			return;
		}
		//조합
		for (int i = start; i < n; i++) {
			if ((flag & (1 << i)) == 0) {
				comb(cnt + 1, flag | 1 << i, i + 1, score + arr[i]);
			}
		}
	}

}