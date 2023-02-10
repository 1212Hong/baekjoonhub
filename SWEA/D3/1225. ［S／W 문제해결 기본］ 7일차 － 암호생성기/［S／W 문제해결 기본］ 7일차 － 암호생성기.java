import java.io.*;
import java.util.*;

public class Solution {
	
	private static int[] arr; //암호를 받는 배열
	private static int test_case;

	public static void main(String args[]) throws Exception
	{

//	System.setIn(new FileInputStream("src/input.txt"));
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	int T = 10;

	for(test_case = 1; test_case <= T; test_case++)
	{
		int n = Integer.parseInt(br.readLine());
		arr = new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Deque<Integer> deq = new ArrayDeque<>();
		// 암호배열
		for (int i=0; i<8; i++) {
			deq.add(Integer.parseInt(st.nextToken()));
		}
		boolean checked=true;
		
		// checked true 계속 반복
		while(checked) {
			// 1~5까지 빼는 사이클 반복
			for (int i=1; i<=5; i++) {
				// deq에서 맨앞의 값을 리턴받고 빼준다
				int x = deq.removeFirst();
				// 그 값에서 i를 뺀 값이 0보다 작을경우
				if (x-i<=0) {
					// 0을 deq의 제일 뒤에 추가
					deq.add(0);
					//while문 종료
					checked = false;
					break;
				}
				// 0보다 큰 경우 i를 뺀 값을 deq의 제일 뒤에 추가
				else {
					deq.add(x-i);
				}
			}	
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : deq) {
			sb.append(i).append(" ");
		}
		
		System.out.println("#" + test_case + " " + sb);
		
	}
	
	}
	
	}
