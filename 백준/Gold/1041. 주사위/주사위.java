import java.io.*;
import java.util.*;

public class Main {
	static long N; //
	static int[] arr = new int[7];

	static int[] num2 = new int[2];
	static int[] num3 = new int[3];

	static long minTwo = Long.MAX_VALUE;
	static long minThree = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		long result = 0;

		if (N == 1) {
			Arrays.sort(arr);
			result = Arrays.stream(arr).sum() - arr[6];

		} else {
			combi2(0, 1, 0, 2);
			combi3(0, 1, 0, 3);

			long n3 = 4;

			long n2 = ((N - 2) * 4) + ((N - 1) * 4);

			long n1 = ((N - 2) * (N - 2)) + ((N - 2) * (N - 1) * 4);

			long num3 = 4 * minThree;

			long num2 = n2 * minTwo;

			long num1 = n1 * min;

			result = num1 + num2 + num3;
		}

		sb.append(result);
		System.out.println(sb);

	}

	private static void combi2(int cnt, int start, int flag, int limit) {

		if (cnt == limit) {
			int a = num2[0];
			int b = num2[1];

			if (a + b == 7) {
				return;
			}

			int temp = arr[a] + arr[b];
			if (temp < minTwo) {
				minTwo = temp;
			}

			return;

		}

		for (int i = start; i <= 6; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			num2[cnt] = i;
			combi2(cnt + 1, i + 1, flag | 1 << i, limit);
		}

	}

	private static void combi3(int cnt, int start, int flag, int limit) {

		// 1,6 or 2,5 or 3,4
		if (cnt == limit) {

			for (int i = 0; i <= 1; i++) {
				for (int j = i + 1; j <= 2; j++) {
					if (num3[i] + num3[j] == 7) {
						return;
					}
				}
			}

			int a = num3[0];
			int b = num3[1];
			int c = num3[2];

			int temp = arr[a] + arr[b] + arr[c];

			if (temp < minThree) {
				minThree = temp;
			}
			return;

		}

		for (int i = start; i <= 6; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			num3[cnt] = i;
			combi3(cnt + 1, i + 1, flag | 1 << i, limit);
		}

	}
}
