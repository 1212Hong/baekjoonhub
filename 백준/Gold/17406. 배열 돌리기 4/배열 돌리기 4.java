import java.io.*;
import java.util.*;

public class Main {
	static int n; //
	static int m; //
	static int k; // 회전수
	static int[][] arr; // 배열
	static int[] numbers;
	static int[][] rotation;
	static int answer = Integer.MAX_VALUE;;
	static int[][] new_arr;
	static int[][] orig_arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// 배열 입력받기
		orig_arr = new int[n][m];
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				orig_arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		rotation = new int[k][3];

		for (int i = 0; i < k; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			
			rotation[i][0] = Integer.parseInt(st3.nextToken()); // r
			rotation[i][1] = Integer.parseInt(st3.nextToken()); // c
			rotation[i][2] = Integer.parseInt(st3.nextToken()); // s
		}
		
		numbers = new int[k];
		permutation(0, 0);
		

		StringBuilder sb = new StringBuilder();
		sb.append(answer);

		System.out.println(sb);

	}
	
	// 회전 순열 구하는 함수
	private static void permutation(int cnt, int flag) {
		if (cnt == k) {
			for(int a=0; a<n; a++) {
				arr[a] = orig_arr[a].clone();
			}
			
			for (int j : numbers) {
				solution(j);
			}
			
			// 모두 회전시키고 각 행 마다의 최솟값을 구해준다
			for(int i=0; i<n; i++) {
				int sum = 0;
				for (int j=0; j<m; j++) {
					sum += new_arr[i][j];
				}
				if(answer > sum) {
					answer = sum;
				}
			}
			return;

		}

		for (int i = 0; i < k; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}
			numbers[cnt] = i;
			permutation(cnt + 1, flag | (1 << i));
		}
	}

	private static void solution(int z) {
		int r = rotation[z][0];
		int c = rotation[z][1];
		int s = rotation[z][2];
		new_arr = new int[n][m];
		
		//원래 배열을 복사해서 새로운 배열을 만들어줌
		for(int a=0; a<n; a++) {
			new_arr[a] = arr[a].clone();
		}
		
		// s번 껍질 반복한다
		for (int i = 1; i <= s; i++) {
			int x = r - i - 1;
			int y = c - i - 1;

			// x=1, y=2 / 1 3 / 1 4 / 1 5
			
			//y+ 방향
			int count = 2 * i;
			while (count > 0) {
				new_arr[x][y + 1] = arr[x][y];
				y++;
				count--;

			}
			
			//x+ 방향
			count = 2 * i;
			while (count > 0) {
				new_arr[x+1][y] = arr[x][y];
				x++;
				count--;

			}
			
			// y-방향
			count = 2 * i;
			while (count > 0) {
				new_arr[x][y-1] = arr[x][y];
				y--;
				count--;
			}
			
			
			count = 2 * i;
			while (count > 0) {
				new_arr[x-1][y] = arr[x][y];
				x--;
				count--;
			}
			
		}
		// 다시 원본으로 돌려준다
		for(int a=0; a<n; a++) {
			arr[a] = new_arr[a].clone();
		}
		
	}

}
