import java.io.*;
import java.util.*;

public class Main {
	static int n; //
	static int m; //
	static int[][] arr; //
	static int[][] count_arr;
	static List<int[]> chicken = new ArrayList<>();
	static int[] numbers;
	static int[][] temp = new int[1][2];

	static int count = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n
		m = Integer.parseInt(st.nextToken()); // m개의 치킨집

		arr = new int[n][n];

		count_arr = new int[n][n];

		//
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st2.nextToken());
				arr[i][j] = num;

				if (num == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}
		numbers = new int[m];
		comb(0, 0, 0);

//		System.out.println(chicken);

//		sb.append(min);
		System.out.println(min);
	}

	// 치킨집 선택 조합
	private static void comb(int cnt, int start, int flag) {
		if (cnt == m) {
			int sum_city = 0;

			// 카운트하는 배열을 최대값으로 지정
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					count_arr[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for (int number : numbers) {
				// 선택한 치킨집의 좌표값 오기 m개중 1개씩
				temp[0] = chicken.get(number);
				int x = temp[0][0];
				int y = temp[0][1];
				chicken_distance(x, y);
			}
//			System.out.println(Arrays.deepToString(count_arr));
			// 도시의 치킨 거리 합 구한다
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum_city += count_arr[i][j];
//					System.out.println(count_arr[i][j]);
				}
			}

			if (sum_city < min) {
				min = sum_city;
			}

			return;

		}

		for (int i = start; i < chicken.size(); i++) {
			if ((flag & (1 << i)) == 0) {
				numbers[cnt] = i;
				comb(cnt + 1, i + 1, flag | (1 << i));
			}
		}
	}

	// 치킨 거리 구하기
	private static void chicken_distance(int x, int y) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 집과 선택된 치킨집과의 거리
				if (arr[i][j] == 1) {
					sum = Math.abs(x - i) + Math.abs(y - j);
					// 기존에 있던 치킨 거리값 보다 작을경우
					if (sum < count_arr[i][j])
						count_arr[i][j] = sum;
				} else {
					count_arr[i][j] = 0;
				}

			}
		}
		return;
	}

}