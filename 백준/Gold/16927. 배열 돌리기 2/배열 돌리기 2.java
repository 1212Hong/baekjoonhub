import java.io.*;
import java.util.*;

public class Main {
	static int n; //
	static int m; //
	static int r; // 회전수
	static int[][] arr; // 조합 저장 배열
	static int cnt; // m개 뽑는 숫자까지 카운트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		int N = n;
		int M = m;
		// 배열 입력받기
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		int dx = 5;
		int dy = 5;

		int yy;
		int xx;

		// deque로 생성할 반복 개수
		int count = Math.min(n, m) / 2;

		for (int i = 0; i < count; i++) {

			// r % ( n+m-2)*2 횟수만 돌리면 된다
			int rr = r % ((n + m - 2) * 2);

			// 한바퀴 도는것 시작점
			int x = i;
			int y = i;
			Deque<Integer> deq = new ArrayDeque<>();

			// 윗변넣기
			for (yy = 0; yy < m - 1; yy++) {
				deq.addLast(arr[x][y]);
				y++;
			}

			// 오른쪽변넣기
			for (xx = 0; xx < n - 1; xx++) {
				deq.addLast(arr[x][y]);
				x++;
			}

			// 아랫변넣기
			for (yy = 0; yy < m - 1; yy++) {
				deq.addLast(arr[x][y]);
				y--;
			}

			// 오른쪽변넣기
			for (xx = 0; xx < n - 1; xx++) {
				deq.addLast(arr[x][y]);
				x--;
			}

			// deq에 넣기
			while (rr > 0) {
				int temp = deq.removeFirst();
				deq.addLast(temp);
				rr--;
			}

			x = i;
			y = i;

			// 윗변배열 바꿔주기
			for (yy = 0; yy < m - 1; yy++) {
				arr[x][y] = deq.removeFirst();
				y++;
			}

			// 오른쪽배열 바꿔주기
			for (xx = 0; xx < n - 1; xx++) {
				arr[x][y] = deq.removeFirst();
				x++;
			}

			// 아래배열 바꿔주기
			for (yy = 0; yy < m - 1; yy++) {
				arr[x][y] = deq.removeFirst();
				y--;
			}

			// 왼쪽배열 바꿔주기
			for (xx = 0; xx < n - 1; xx++) {
				arr[x][y] = deq.removeFirst();
				x--;
			}

			// nm 범위 줄어들게 만들기
			n -= 2;
			m -= 2;

		}
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
