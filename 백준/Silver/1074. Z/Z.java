import java.io.*;
import java.util.*;

public class Main {
	static int n; //
	static int r; //
	static int c;
	static int start;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 2^N * 2^N 2차원 배열
		r = Integer.parseInt(st.nextToken()); // r행
		c = Integer.parseInt(st.nextToken()); // c열
		int size = (int) (Math.pow(2, n)); // 한 변의 길이

		solution(size, r, c);

		sb.append(result);
		System.out.println(sb);

	}

	// half = 4
	private static void solution(int size, int r, int c) {
		// 한 변의 길이가 1이 될때까지
		if (size == 1)
			return;

		// 1분위
		if (r < size / 2 && c < size / 2) {
			solution(size / 2, r, c);
		}
		// 2분위
		else if (r < size / 2 && c >= size / 2) {

			c = c - (size / 2); // 각 사분면에서 r,c의 상대적 위치를 바꿔준다
			result += size * size / 4; // 1분위까지 더해준 값을 더해준다
			solution(size / 2, r, c);
		}
		// 3분위
		// size =4, r= 3, c = 1
		// r=1, c =1
		else if (r >= size / 2 && c < size / 2) {
			r = r - (size / 2); // 각 사분면에서 r,c의 상대적 위치를 바꿔준다
			result += size * size / 4 * 2; // 1~2분위까지 더해준 값을 더해준다
			solution(size / 2, r, c);
		}
		// 4분위
		else {
			// 각 사분면에서 r,c의 상대적 위치를 바꿔준다
			r = r - (size / 2);
			c = c - (size / 2);
			result += size * size / 4 * 3; // 1~3분위까지 더해준 값을 더해준다
			solution(size / 2, r, c);
		}

	}
}
