import java.io.*;
import java.util.*;

public class Main {

	static int N, S;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MAX_VALUE;

		int left = 0;
		int right = 0;

		int sum = 0;

		while (true) {
			if (sum >= S) {
				sum -= numbers[left++];
			} else if (right == N) {
				break;
			} else {
				sum += numbers[right++];
			}
			if (sum >= S) {
				answer = Math.min(answer, right - left);
			}
		}
		if (answer == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}

	}

}