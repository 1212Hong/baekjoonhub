import java.io.*;
import java.util.*;

public class Main {
	private static int n; //
	private static int m; //
	private static int[] arr; 
	private static int[] numbers;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		arr = new int[9];
		numbers = new int[7];
		for (int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		comb(0, 0, 0);

		
		
	}

	private static void comb(int cnt, int start, int flag) {
		if(cnt==7) {
			int sum = 0;
			for (int num : numbers) {
				sum += arr[num];
			}
			if (sum==100) {
				for (int num : numbers) {
					sb.append(arr[num]).append("\n");
				}
				System.out.println(sb);
				System.exit(0);
				
			}
			return;
		}
		
		for (int i=start; i<9; i++) {
			if ((flag & (1<<i)) ==0) {
				numbers[cnt] = i;
				comb(cnt+1, i+1, flag | 1<<i);
			}
		}
	}

}
