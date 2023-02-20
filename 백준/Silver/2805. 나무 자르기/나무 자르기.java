import java.io.*;
import java.util.*;

public class Main {
	private static int n; //
	private static int m; //
	private static long[] arr; //

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 나무의 수
		m = Integer.parseInt(st.nextToken()); // 나무의 길이

		arr = new long[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		// 오름차순정렬
		Arrays.sort(arr);

		// start end 절단기의 높이 범위는 1부터 나무길이의 최대값 사이
		long start = 1;
		long end = arr[arr.length - 1];
		long mid;
		long answer = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			long sum = 0;

			// 설정한 절단기보다 나무 높이가 높을경우 sum에 합하여 준다
			for (long tree : arr) {
				if (tree > mid) {
					sum += tree - mid;
				}
			}
			// 자른 나무의 합이 m 보다 작은 경우 절단기의 높이가 너무 높은 경우이므로 높이를 낮춰준다
			if (sum < m) {
				end = mid - 1;
			}
			// m을 넘었을 경우 절단기의 높이 범위를 더 높여준다
			else {
				answer = mid;
				start = mid + 1;
			}

		}
		sb.append(answer);
		System.out.println(sb);

	}

}