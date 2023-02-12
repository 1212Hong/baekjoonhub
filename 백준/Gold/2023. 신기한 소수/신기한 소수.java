import java.io.*;
import java.util.*;

public class Main {
	private static int n; // n자리 수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		//1자리수 2, 3, 5, 7만 소수 가능
		comb(1,2);
		comb(1,3);
		comb(1,5);
		comb(1,7);
	}
	
	private static void comb(int cnt, int num) {
		if (cnt==n) {
			if(isprime(num)) {
				System.out.println(num);
			}
			return;
		}
		//2,4,6,8 로 떨어지면 나누어지므로 소수 아님
		for (int i=1; i<10; i++) {
			if (i==2 || i==4 || i==6 || i==8)
				continue;
			if(isprime(num*10 + i))
				comb(cnt+1, num*10 + i);
		}
	}
	
	private static boolean isprime(int num) {
		for (int i=2; i*i<=num; i++) {
			if(num%i==0) {
				return false;
			}
			
		}
		return true;
	}

}