import java.io.*;
import java.util.*;

public class Main {
	static int n; // 탑의 개수
	static int[] arr; // 탑 높이 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap();

		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> deq = new ArrayDeque<>();

		// 초기값

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			
			//stack 비어 있으면 0 출력
			if (deq.isEmpty()) {
				sb.append(0).append(" ");
				deq.addLast(arr[i]);
				map.put(arr[i], i);
				continue;
			}

			// stack이 빌 때까지 반복
			while (!deq.isEmpty()) {

				int y = deq.getLast();
				int idx = map.get(y);

				// stack의 peek와 현재 값 비교
				if (y < arr[i]) {
					deq.removeLast();// 현재 값이 크면 pop
				} else {
					sb.append(idx + 1).append(" ");//작으면 현재 stack의 peek 출력
					break;
				}
			}
			// 비어 있으면 0 출력
			if (deq.isEmpty()) {
				sb.append(0).append(" ");
			}
			
			//stack에 값 넣기
			deq.addLast(arr[i]);
			map.put(arr[i], i);

		}

		System.out.println(sb);

	}

}