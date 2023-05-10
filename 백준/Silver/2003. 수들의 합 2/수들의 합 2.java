import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;

		int left = 0;
		int right = 0;

		int sum = 0;

		while (true) {
			if (sum >= M) {
				sum -= numbers[left++];
			} else if (right == N) {
				break;
			} else {
				sum += numbers[right++];
			}
			if (sum == M) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}