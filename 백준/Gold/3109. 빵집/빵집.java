import java.io.*;
import java.util.*;

public class Main {
	static int R, C, col[], answer; // 표의 크기
	static char[][] map; //
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	private static boolean isIn(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			bread(i, 0);
		}
		sb.append(answer);
		System.out.println(sb);

	}

	private static boolean bread(int x, int y) {
		if (y == C - 1) {
			answer += 1;
			return true;
		}

		map[x][y] = 'x';

		int pX = 0;
		int pY = 0;
		for (int i = 0; i < 3; i++) {
			pX = x + dx[i];
			pY = y + dy[i];
			if (isIn(pX, pY) && map[pX][pY] == '.') {
				if (bread(pX, pY))
					return true;
			}
		}
		return false;
	}

}