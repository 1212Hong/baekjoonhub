import java.io.*;
import java.util.*;

public class Main {
	static int n; // N킬로그램

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine()); // n

		// 5키로 이상일 경우
		if (n >= 5) {
			// 5키로를 쓸 수 있는 최대값부터 --로 계산
			for (int i = n / 5; i >= 0; i--) {
				int cnt_5 = i;
				int x = n - (5 * i);
				int cnt_3 = x / 3;
				int y = x % 3;
				if (y == 0) {
					sb.append(cnt_5 + cnt_3);
					System.out.println(sb);
					return;
				}
			}
			// 위 조건에서 출력 못하면 계산하지 못하는 경우이므로 -1
			sb.append(-1);
			System.out.println(sb);

		}
		// 5키로 미만일때 3으로 나눈 경우 계산
		else {
			if ((n % 3) == 0) {
				sb.append(n / 3);
				System.out.println(sb);
			} else {
				sb.append(-1);
				System.out.println(sb);
			}
		}

	}

}