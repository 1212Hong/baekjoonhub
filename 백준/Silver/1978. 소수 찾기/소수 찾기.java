import java.io.*;
import java.util.*;

public class Main {
	static int n; //
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine()); // n개

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			solution(x);
		}

		sb.append(count);
		System.out.println(count);
	}

	private static void solution(int x) {
		if(x==1) {
			return;
		}
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return;
			}
		}
		count += 1;
		return;
	}

}