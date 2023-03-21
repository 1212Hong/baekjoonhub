import java.io.*;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(B, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (A[i] * B[i]);
		}

		sb.append(sum);
		System.out.println(sb);

	}

}
