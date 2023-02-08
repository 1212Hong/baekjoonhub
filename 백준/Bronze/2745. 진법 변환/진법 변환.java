import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static String x;
	private static int y;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = st.nextToken();
		y = Integer.parseInt(st.nextToken());
		int sum = 0;
		int temp = 1;
		
		//인덱스 거꾸로 부터 올라감
		for(int i=x.length()-1; i>=0; i--) {
			char a = x.charAt(i);
			if ('A'<=a && a<='Z') {
				sum += (a -'A' + 10)*temp;
			}
			else {
				sum += (a - '0')*temp;
			}
			// 자리수마다 제곱수 올라감
			temp *= y;
			
		}
		
		System.out.println(sum);
		
		}
	
}
