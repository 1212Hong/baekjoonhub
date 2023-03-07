import java.io.*;
import java.util.*;

public class Solution {

	static int test_case;

	static int N, K;

	static int[][] map, newMap;

	static char[] picks;

	static Deque<Character> deque;

	static Set<String> set;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			deque = new ArrayDeque<>();
			set = new HashSet<>();
			Map<Integer, String> map = new HashMap<Integer, String>();

			char[] arr = br.readLine().toCharArray();

			int rotate = N / 4;

			picks = new char[rotate];

			// 초기값 String 으로 바꿔서 set에 넣어준다
			String s;
			for (int i = 0; i <= N - rotate; i += rotate) {
				s = "";
				for (int j = i; j < i + rotate; j++) {
					s += Character.toString(arr[j]);
					deque.addLast(arr[j]);
				}
				set.add(s);

			}
			int pick_num = rotate;

			while (rotate-- > 0) {
				char c = deque.removeFirst();
				deque.addLast(c);
				pick(pick_num);

			}

			int sum;
			int x, y;
			for (String num : set) {
				sum = 0;
				char[] temp = num.toCharArray();
				x = 1;

				for (int i = temp.length - 1; i >= 0; i--) {

					if (temp[i] >= 'A' && temp[i] <= 'F') {
						y = temp[i] - 55;
					} else {
						y = temp[i] - '0';
					}
					sum += (y * x);

					x *= 16;

				}
				map.put(sum, num);

			}

			List<Integer> keySet = new ArrayList<>(map.keySet()); // 10진수로 바꾼 key 리스트

			Collections.sort(keySet, Collections.reverseOrder()); // 키 값으로 오름차순 정렬

			int answer = keySet.get(K - 1);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			sb.append(answer);
			System.out.println(sb);

		}

	}

	private static void pick(int pick_num) {
		int check = 4;
		char c;
		String s;

		while (check-- > 0) {
			s = "";
			for (int i = 0; i < pick_num; i++) {
				c = deque.removeFirst();
				picks[i] = c;
				s += Character.toString(c);

			}

			set.add(s);

			for (int i = 0; i < pick_num; i++) {
				deque.addLast(picks[i]);
			}

		}



	}

}
