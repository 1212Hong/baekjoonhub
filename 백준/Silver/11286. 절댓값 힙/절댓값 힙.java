import java.io.*;
import java.util.*;

public class Main {
	static int n; // 연산의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 음수는 최대힙
		PriorityQueue<Integer> pQHighest = new PriorityQueue<>(Collections.reverseOrder());

		// 양수는 최소힙
		PriorityQueue<Integer> pQLowest = new PriorityQueue<>();

		n = Integer.parseInt(br.readLine()); // n

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			// 입력값이 0인경우
			if (x == 0) {
				// 0인데 비어있는 경우 0 출력
				if (pQLowest.isEmpty()&&pQHighest.isEmpty()) {
					sb.append("0").append("\n");
				}
				// 양수 최소힙이 비어있을경우 음수 최대힙에서 출력
				else if (pQLowest.isEmpty()) {
					sb.append(pQHighest.poll()).append("\n");
				}
				// 음수 최대힙 비어있을경우 양수 최소힙 출력
				else if (pQHighest.isEmpty()) {
					sb.append(pQLowest.poll()).append("\n");
				}
				// 아닐경우
				else {
					//양수에서 하나 꺼내기
					int a = Math.abs(pQLowest.peek());
					//음수에서 하나 꺼내기
					int b = Math.abs(pQHighest.peek());
					
					//같은경우 음수에서 빼준다
					if (a==b) {
						sb.append(pQHighest.poll()).append("\n");
					}
					else if (a<b) {
						sb.append(pQLowest.poll()).append("\n");
					}
					else {
						sb.append(pQHighest.poll()).append("\n");
					}
					
				}
			}
			//0이 아닌경우 힙에 넣기
			else {
				//양수이면 최소힙에 넣기
				if (x > 0) {
					pQLowest.add(x);
				}
				//음수이면 최대힙에 넣기
				else {
					pQHighest.add(x);
				}

			}

		}

		System.out.println(sb);
	}

}