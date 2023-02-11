import java.io.*;
import java.util.*;

public class Main {
	private static int n; // 단어의 개수 n
	private static int k; // 배울 단어의 개수 k
	private static boolean[] checked;
	private static int count; // 최대 개수
	private static char[] alpha; // 구간합
	private static String[] words;
	
	private static Set<Character> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// k 개수가 5개 미만이면 0 출력
		if (k <= 4) {
			System.out.println(0);
			return;
		}

		else if (k == 26) {
			System.out.println(n);
			return;
		}

		count = 0;

		// 단어 입력받기
		words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		// 남극 기본 언어 알파벳을 제외한 알파벳 목록
		alpha = new char[] { 'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w',
				'x', 'y', 'z' };

		// 남극 단어의 시작 끝 알파벳이 최소 5개이므로 그보다 작으면 못 읽는다

		// set에 기본단어 추가
		set = new HashSet<Character>();
		set.add('a');
		set.add('c');
		set.add('i');
		set.add('n');
		set.add('t');
		checked = new boolean[21];
		comb(0, 0);
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

	// 조합 구하기
	private static void comb(int cnt, int start) {
		if (cnt == k - 5) {
			for (int i = 0; i < 21; i++) {
				if (checked[i]) {
					// set에 조합으로 고른 알파벳 추가
					set.add(alpha[i]);
					// 추가한 알파벳 저장 리스트
				}
			}
			solution(set);

			// 조합으로 추가한 알파벳 다시 제거
			for (int j = 0; j < 21; j++) {
				if (checked[j]) {
					set.remove(alpha[j]);
				}
			}

			return;
		}

		for (int i = start; i < 21; i++) {
			checked[i] = true;
			comb(cnt + 1, i + 1);
			checked[i] = false;
		}

	}

	private static void solution(Set<Character> set) {
		int sum = 0;
		// 받은 단어들 검사
		for (int i = 0; i < n; i++) {

			boolean bool = true;

			// 남극 알파벳을 제외한 단어만 검사
			for (int j = 4; j < words[i].length() - 4; j++) {

				// 단어가 없는경우 break
				if (!set.contains(words[i].charAt(j))) {
					bool = false;
					break;
				}
			}
			// 조합으로 나온 알파벳으로 통과했다면 sum+1
			if (bool) {
				sum += 1;
			}

		}

		count = Math.max(count, sum);

		return;

	}

}