import java.io.*;
import java.util.*;

public class Main {
	static int N; // 표의 크기
	static char[][] map; //
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		cut(0, 0, N);

		System.out.println(sb);

	}

	// 다 똑같은 숫자인지 체크
	private static boolean isPossible(int x, int y, int size) {
		int value = map[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (value != map[i][j]) {
					return false;
				}
			}
		}
		return true;

	}

	private static void cut(int r, int c, int size) {
		// 압축이 가능하면 그 숫자를 출력에 넣어줌
		if (isPossible(r, c, size)) {
			sb.append(map[r][c]);
			return;
		}

		int half = size / 2;

		sb.append("(");

		// 4분할 탐색
		cut(r, c, half);
		cut(r, c + half, half);
		cut(r + half, c, half);
		cut(r + half, c + half, half);

		sb.append(")");

	}

}