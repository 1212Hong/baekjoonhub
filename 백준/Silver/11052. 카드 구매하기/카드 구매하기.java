import java.io.*;
import java.util.*;

public class Main {
	static int N; // 카드 개수
	static int[] card; //
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		card = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 1];

		dp[1] = card[0];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
			}
		}

		System.out.println(dp[N]);

	}

}