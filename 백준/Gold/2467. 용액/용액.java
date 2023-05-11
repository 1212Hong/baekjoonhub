import java.io.*;
import java.util.*;

public class Main {

	static int N, S;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N - 1;

		int sum = numbers[left] + numbers[right];
		int answer = Math.abs(sum);
		int x = numbers[0];
		int y = numbers[N - 1];

		while (true) {
			if (sum > 0) {
				sum = (numbers[left] + numbers[--right]);
			} else if (sum == 0) {
				x = numbers[left];
				y = numbers[right];
				break;
			} else {
				sum = (numbers[++left] + numbers[right]);
			}

			if (left == right) {
				break;
			}
			if (Math.abs(sum) < answer) {
				answer = Math.abs(sum);
				x = numbers[left];
				y = numbers[right];

			}
		}
		System.out.println(x + " " + y);

	}

}