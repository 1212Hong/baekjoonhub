import java.io.*;
import java.util.*;

public class Main {
	private static int n; // 수의 개수 n
	private static ArrayList<Integer> list;
	private static int[] arr_s; // 신맛 배열
	private static int[] arr_b; // 쓴맛 배열
	private static boolean[] isSelected; // 쓴맛 배열
	private static int[] numbers;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//재료 n개
		n = Integer.parseInt(br.readLine());
		
		isSelected = new boolean[n];
		list = new ArrayList<>();//값 차이 넣을 리스트
		numbers = new int[n];//식재료 순번 배열
		arr_s = new int[n];
		arr_b = new int[n];
		//각 재료의 신맛 쓴맛
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr_s[i] = s;
			arr_b[i] = b;
			numbers[i] = i;
		}
		
		generateSubSet(0);
		System.out.println(Collections.min(list));
		
	}
	
	private static void generateSubSet(int cnt) {
		
		if(cnt ==n) {
			int multiply_s = 1;
			int add_b = 0;
			for (int i=0; i<n; i++) {
				if (isSelected[i]==true) {
					multiply_s *= arr_s[i];
					add_b += arr_b[i];
				}
			}
			if (add_b != 0) {
				list.add(Math.abs(multiply_s-add_b));
			}
			return;
		}
		
		isSelected[cnt] = false;
		generateSubSet(cnt+1);
		
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		
	}

}