import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int R, C, startX, startY, endX, endY, answer;

	static Queue<Point> waters = new ArrayDeque<>();

	static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
				if (c == 'S') {
					startX = i;
					startY = j;
				} else if (c == 'D') {
					endX = i;
					endY = j;
				} else if (c == '*') {
					waters.add(new Point(i, j, 0));
				}

			}
		}

		boolean flag = bfs(startX, startY);

		if (flag) {
			System.out.println(answer);
		} else {
			System.out.println("KAKTUS");
		}

	}

	private static boolean bfs(int startX, int startY) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(startX, startY, 0));
		visited[startX][startY] = true;

		Point current;
		while (!q.isEmpty()) {

			int len = waters.size();

			water(len);

			int lenQ = q.size();
			for (int i = 0; i < lenQ; i++) {
				current = q.poll();
				int x = current.x;
				int y = current.y;
				int time = current.time;

				for (int d = 0; d < 4; d++) {

					int nx = x + dx[d];
					int ny = y + dy[d];

					if (!isIn(nx, ny))
						continue;

					if (map[nx][ny] == 'D') {
						answer = time + 1;
						return true;
					}

					else if (map[nx][ny] == '.') {
						map[nx][ny] = 'S';
						q.add(new Point(nx, ny, time + 1));

					}

				}

			}

		}

		return false;

	}

	private static void water(int len) {

		Point water;
		for (int i = 0; i < len; i++) {
			water = waters.poll();
			int x = water.x;
			int y = water.y;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (!isIn(nx, ny))
					continue;
				if (map[nx][ny] == '.') {

					map[nx][ny] = '*';
					waters.add(new Point(nx, ny, 0));
				}

			}

		}

	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 & x < R & y >= 0 & y < C) {
			return true;
		}
		return false;
	}

}