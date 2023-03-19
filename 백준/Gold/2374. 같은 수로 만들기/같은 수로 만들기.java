import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Deque<Long> deq = new ArrayDeque<>();
		long result = 0;

		long temp;
		long max = 0;

		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(br.readLine());
			max = Math.max(max, temp);

			if (deq.isEmpty()) {
				deq.add(temp);
			} else {
				if (deq.peekLast() < temp) { // 새로운 값이 deq 의 값보다 클경우 그 차를 더해줌
					result += temp - deq.pollLast();
					deq.add(temp);
				} else { //
					deq.poll();
					deq.addLast(temp);
				}
			}

		}
		
		while(!deq.isEmpty()) {
			result += max - deq.poll();
		}

		sb.append(result);

		System.out.println(sb);

	}

}