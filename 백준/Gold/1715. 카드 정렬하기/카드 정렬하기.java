import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	private static int N;
	private static int[][] games;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			priorityQueue.add(num);
		}
		int answer = 0;
		while (priorityQueue.size() != 1) {
			int x = priorityQueue.poll();
			int y = priorityQueue.poll();
			int temp = x + y;
			answer += temp;
			priorityQueue.add(temp);
		}

		System.out.println(answer);

	}

}
