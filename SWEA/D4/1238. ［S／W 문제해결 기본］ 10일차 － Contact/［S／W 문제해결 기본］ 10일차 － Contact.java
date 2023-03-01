import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution {

	static int test_case;

	static ArrayList<Integer>[] graph;

	static ArrayList<Integer> list;

	public static void main(String args[]) throws Exception {

//	System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for (test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			graph = new ArrayList[101];

			for (int i = 0; i < 101; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			// 연락 가능한 정보 graph에 저장
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st2.nextToken());
				int to = Integer.parseInt(st2.nextToken());
				graph[from].add(to);
			}

			// bfs로 탐색
			bfs(n);

			// 제일 마지막 단계의 번호들의 list 중 최대값을 결과값에 넣어준다
			int result = Collections.max(list);
			sb.append(result);

			System.out.println(sb);
		}

	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[101];

		q.offer(start);
		visited[start] = true;

		int current = 0;
		while (!q.isEmpty()) {
			int cnt = q.size();
			// 한 단계씩 내려갈때마다 list를 생성해주어 그 번호들을 list에 모두 저장해준다
			list = new ArrayList<Integer>();
			while (cnt > 0) {
				current = q.poll();
				list.add(current);
				for (int num : graph[current]) {
					if (!visited[num]) {
						q.offer(num);
						visited[num] = true;
					}
				}
				cnt--;
			}

		}

	}

}
