import java.io.*;
import java.util.*;

public class Main {
	private static int s; // DNA 문자열 길이
	private static int p; // 부분문자열 길이
	
	private static Map<Character, Integer> count_dna; // 문자열에 있는 ACGT 개수 카운트
	private static Map<Character, Integer> orig_dna; // ACGT 최소 개수
	private static Map<Character, Integer> password; // 비밀번호
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		orig_dna = new HashMap<>();
		count_dna = new HashMap<>();
		password = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		//DNA문자열에 들어있는 ACGT 개수 카운트
		char[] dna = br.readLine().toCharArray();
		for (int d=0; d<dna.length; d++) {
			if(!count_dna.containsKey(dna[d])) {
				count_dna.put(dna[d], 1);
			}
			else {
				int oldValue = count_dna.get(dna[d]);
				int newValue = oldValue + 1;
				count_dna.put(dna[d], newValue);
			}
		}
				
		boolean checked = true;
		char[] dna_list = {'A', 'C', 'G', 'T'};
		// ACGT 최소개수
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// 주어진 문자열의 dna개수와 써야하는 문자열의 dna 개수가 맞지 않으면 break
		for(int n=0; n<4; n++) {
			orig_dna.put(dna_list[n], Integer.parseInt(st2.nextToken()));
			
			if(!count_dna.containsKey(dna_list[n])) {
				count_dna.put(dna_list[n], 0);
			}
			if( orig_dna.get( dna_list[n] ) > count_dna.get(dna_list[n]) ){
				checked = false;
				break;
			}
		}
		
		//비번 가능한
		int count = 0;
		if(checked) {
			//초기 p개의 길이만큼 분석
			for (int i=0; i<p; i++) {
				// password 맵에 카운트
				if(!password.containsKey(dna[i])) {
					password.put(dna[i], 1);
				}
				else {
					int oldValue = password.get(dna[i]);
					int newValue = oldValue + 1;
					password.put(dna[i], newValue);
				}
			}
			
			//초기 값이 조건에 충전하나 체크
			boolean checked1 = true;
			for (int x=0; x<4; x++) {
				char temp = dna_list[x];
				if(!password.containsKey(temp)) {
					password.put(temp, 0);
				}
				if(orig_dna.get(temp)>password.get(temp)) {
					checked1 = false;
					break;
				}
			}
			
			if(checked1) {
				count +=1;
			}

			
				//슬라이딩 윈도우
				for (int j=p; j<s; j++) {
					int z = j-p;//전 배열의 첫번째 인덱스
					int oldValue = password.get(dna[z]);
					int newValue = oldValue - 1;
					password.put(dna[z], newValue);
					
					//새로 추가되는 인덱스값
					if(!password.containsKey(dna[j])) {
						password.put(dna[j], 1);
					}
					else {
						int oldnum = password.get(dna[j]);
						int newnum = oldnum + 1;
						password.put(dna[j], newnum);
					}
					
					//검사
					boolean checked2 = true;
					for (int x=0; x<4; x++) {
						char temp = dna_list[x];
						if(!password.containsKey(temp)) {
							password.put(temp, 0);
						}
						if(orig_dna.get(temp)>password.get(temp)) {
							checked2 = false;
							break;
						}
					}
					if(checked2) {
						count +=1;
					}
					
					
					
				}
			
			System.out.println(count);
		}
		
		else {
			System.out.println(0);
		}
		
	}

}