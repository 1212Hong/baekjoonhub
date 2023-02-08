import java.io.*;
import java.util.*;

public class Main {
	private static int n; // 표의 크기
	private static int m; // 합 구해야 하는 횟수
	private static int[][] sum; // 구간합
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//구간합 배열
		sum = new int[n+1][n+1];
		
		// 2차원 배열 받기
		for (int a=1; a<n+1; a++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int b=1; b<n+1; b++) {
				// 누적합 구하는 방법
				sum[a][b] = sum[a-1][b] + sum[a][b-1] + Integer.parseInt(st1.nextToken()) - sum[a-1][b-1];
			}
		}
				
		for (int z=0; z<m; z++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st2.nextToken());
			int y1 = Integer.parseInt(st2.nextToken());
			int x2 = Integer.parseInt(st2.nextToken());
			int y2 = Integer.parseInt(st2.nextToken());
			
			//누적합 차를 구하는 방식
			System.out.println( sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
		}
		
	}

}