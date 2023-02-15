import java.io.*;
import java.util.*;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // 색종이의 수
		int[][] arr = new int[100][100];

		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int org_x = Integer.parseInt(st.nextToken());
			int org_y = Integer.parseInt(st.nextToken());

			for (int a = org_x; a < org_x + 10; a++) {
				for (int b = org_y; b < org_y + 10; b++) {

					arr[a][b] += 1;
				}

			}
		}

		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] >= 1)
					result += 1;
			}
		}

		System.out.println(result);

	}
}