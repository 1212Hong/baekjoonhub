import java.io.*;
import java.util.*;

public class Main {
	static int n; //
	static int l;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 과일개수
		l = Integer.parseInt(st.nextToken());
		
		//과일 길이 받는법
		arr = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		
		for (int height : arr) {
			if (l<height) {
				break;
			}
			l++;
		}
		sb.append(l);
		System.out.println(sb);

	}

}