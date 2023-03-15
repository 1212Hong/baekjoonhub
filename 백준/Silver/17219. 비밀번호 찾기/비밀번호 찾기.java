import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			map.put(A, B);
		}

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			sb.append(map.get(s)).append("\n");
		}

		System.out.println(sb);

	}

}