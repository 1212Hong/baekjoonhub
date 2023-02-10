import java.io.*;
import java.util.*;

public class Main {
	private static int n; //N장의 카드
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new ArrayDeque<>();
		
		//deq 에 1~n장까지의 카드를 넣어준다
		for (int i=1; i<=n; i++) {
			deq.add(i);
		}
		//deq의 카드가 1장남으면 멈춤다
		while(deq.size()>1) {
			//제일 앞장의 카드를 버려준다
			deq.removeFirst();
			//그 다음 카드를 빼주고
			int x = deq.removeFirst();
			//다시 맨 뒤로 더해준다
			deq.addLast(x);
		}
		
		System.out.println(deq.remove());
	}

}
