import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n; // 수의 개수 n
	private static int m; // 합 구해야 하는 횟수
	private static int[] sum; // 구간합
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		//구간합0 0으로 설정하기
		sum = new int[n+1];
		sum[0] = 0;
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		// 수 배열 받기
		for (int a=1; a<n+1; a++) {
			sum[a] = sum[a-1] + Integer.parseInt(st1.nextToken());
			
		}
		
		for (int b=0; b<m; b++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st3.nextToken());
			int end = Integer.parseInt(st3.nextToken());
			System.out.println(sum[end]-sum[start-1]);
		}
		
	}

}