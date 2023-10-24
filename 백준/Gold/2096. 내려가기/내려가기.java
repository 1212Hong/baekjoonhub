import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[] dx = {1, 1, 1};
	private static int[] dy = {0, 1, -1};
	private static int[][] games;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		games = new int[N + 1][3];
		int[][] maxDp = new int[N + 1][3];
		int[][] minDp = new int[N + 1][3];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				games[i][j] = temp;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + games[i][0];
			maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + games[i][1];
			maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + games[i][2];

			minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + games[i][0];
			minDp[i][1] = Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2])) + games[i][1];
			minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + games[i][2];
		}

		int maxAnswer = Math.max(maxDp[N][0], Math.max(maxDp[N][1], maxDp[N][2]));
		int minAnswer = Math.min(minDp[N][0], Math.min(minDp[N][1], minDp[N][2]));
		System.out.println(maxAnswer + " " + minAnswer);

	}

}
