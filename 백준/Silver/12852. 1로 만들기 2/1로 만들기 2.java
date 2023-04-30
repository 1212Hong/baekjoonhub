import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[n+1];	// 최소 횟수 저장
		int[] path = new int[n+1];	//경로 저장
		Arrays.fill(d, Integer.MAX_VALUE);//초기화
		
		d[1] = 0;
		for (int i = 2; i <= n; i++) {

			if(i%3 == 0) {
				if(d[i/3] +1 < d[i]) {
					d[i] = d[i/3] +1;
					path[i] = i/3;
				}
			}
			if(i%2 == 0) {
				if(d[i/2] +1 < d[i]) {
					d[i] = d[i/2] +1;
					path[i] = i/2;
				}
			}
			
			if(d[i-1] +1 < d[i]) {
				d[i] = d[i-1] +1;
				path[i] = i-1;
			}
			
		}
		
		sb.append(d[n]+"\n");
		
		while (n > 0) {
			sb.append(n+" ");
			n =path[n];
			
		}
		
		System.out.println(sb.toString());
		
	}

}