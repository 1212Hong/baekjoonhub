import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution {

	private static ArrayList<String>[] arr; // 상자의 높이를 받는 배열
	private static int test_case;

	public static void main(String args[]) throws Exception {

//	System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for (test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			arr = new ArrayList[n];
			// 상자의 높이를 받는 배열
			for (int i = 0; i < n; i++) {
				arr[i] = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 각 정점의 해당 값 arr에 넣기
				while (st.hasMoreTokens()) {
					arr[i].add(st.nextToken());
				}

			}
			
			boolean check = true;
			for (int j=0; j<n; j++) {
				// 자식노드가 있을 경우 그 정점이 연산자가 와야한다
				if(arr[j].size()>=3) {
					if (! (arr[j].get(1).equals("+") || arr[j].get(1).equals("-") || arr[j].get(1).equals("*") || arr[j].get(1).equals("/"))) {
						System.out.println("#" + test_case + " " + "0");
						check = false;
						break;
					}
				}
				
				// 자식노드 없을 경우
				else {
					if (arr[j].get(1).equals("+") || arr[j].get(1).equals("-") || arr[j].get(1).equals("*") || arr[j].get(1).equals("/")){
						System.out.println("#" + test_case + " " + "0");
						check = false;
						break;
					}
				}
				// 안되는 경우 통과하였을 경우 1
				
			}
			if (check)
				System.out.println("#" + test_case + " " + "1");

		}

	}

}
