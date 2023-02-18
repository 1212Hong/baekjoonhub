import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		char[] s = br.readLine().toCharArray();
		int len = s.length;
		if (len % 3 == 1) {
			sb.append(s[0]);
		} else if (len % 3 == 2) {
			sb.append(charToInt(s[0]) * 2 + charToInt(s[1]));
		}
		for (int i = len % 3; i < len; i += 3) {
			sb.append(charToInt(s[i]) * 4 + charToInt(s[i + 1]) * 2 + charToInt(s[i + 2]));
		}
		System.out.print(sb);
	}

	static int charToInt(char c) {
		return c - '0';
	}

}