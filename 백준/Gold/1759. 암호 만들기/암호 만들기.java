import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] arr;
	static int[] numbers;
	static List<Character> moeum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = st2.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		moeum = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

		numbers = new int[L];

		combination(0, 0, 0);

		System.out.println(sb);

	}

	// 조합
	private static void combination(int cnt, int start, int flag) {
		if (cnt == L) {
			int check_a = 1; // 모음개수 체크
			int check_b = 2; // 자음개수 체크
			char[] temp = new char[L];

			for (int i = 0; i < L; i++) {
				char c = arr[numbers[i]];
				temp[i] = c;

				if (moeum.contains(c)) {
					check_a--;
				} else {
					check_b--;
				}

			}

			if (check_a <= 0 && check_b <= 0) {
				for (int i = 0; i < L; i++) {
					sb.append(temp[i]);
				}
				sb.append("\n");
				return;
			}
			return;

		}

		for (int i = start; i < C; i++) {
			if ((flag & (1 << i)) == 0) {
				numbers[cnt] = i;
				combination(cnt + 1, i + 1, flag | (1 << i));
			}
		}
	}

}