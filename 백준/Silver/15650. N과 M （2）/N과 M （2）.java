import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n; // 자연수 n까지
	private static int m; // 중복 없이 m개
	private static int[] numbers;	//조합 저장 배열
	private static int cnt; // m개 뽑는 숫자까지 카운트
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[m];
		
		//카운트 0, 자연수 1 부터 시작
		combination(0, 1);
		
	}
	
private static void combination(int cnt, int start) {
		// cnt 가 m개가 되면 m개를 고른 것이므로 출력
		if (cnt == m) {
			for (int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		//i가 i+1 start 하는 재귀함수로 돌아가 조합을 구함
		for (int i=start; i<=n; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
}}