import java.io.*;
import java.util.*;

public class Main {
	static int n; //
	static int m; //
	static int[][] arr; //
	static int[][] arr2;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n
		m = Integer.parseInt(st.nextToken()); // m

		arr = new int[n][m];
		arr2 = new int[n][m];

		// 첫번째 배열
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		// 두번째 배열
		for (int i = 0; i < n; i++) {
			String s2 = br.readLine();
			for (int j = 0; j < m; j++) {
				arr2[i][j] = s2.charAt(j) - '0';
			}
		}

		// 시작점 설정
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				checking(i, j); // 시작점부터 3X3 배열 체크하는
			}
		}

		// 일치하는지 체크
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != arr2[i][j]) {
					sb.append(-1);
					System.out.println(sb);
					return;
				}
			}
		}

		sb.append(count);

		System.out.println(sb);
	}

	// 3X3 배열 서로 체크
	private static void checking(int i, int j) {
		if (arr[i][j] != arr2[i][j]) {
			reversing(i, j); // 일치하지 않으면 i,j를 시작점으로 3X3 뒤집기
			return; // 그 다음 시작점으로 이동
		}
	}

	// 3X3 -> 1,0 바꿔주기
	private static void reversing(int x, int y) {
		// x or y 가 범위를 벗어나면 바꾸지 않는다
		if (x + 2 >= n || y + 2 >= m) {
			return;
		}

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {

				if (arr[i][j] == 1) {
					arr[i][j] = 0;
				} else if (arr[i][j] == 0) {
					arr[i][j] = 1;
				}
			}
		}
		count++;
//		System.out.println(Arrays.deepToString(arr));
		return;

	}

}