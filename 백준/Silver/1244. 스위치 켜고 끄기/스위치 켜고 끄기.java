import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n; //스위치 개수
	private static int[] arr;	//스위치 저장 배열
	
	private static int s; // 학생수	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());	//스위치 개수
		arr = new int[n];
		
		// 스위치 배열받음
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		s = Integer.parseInt(br.readLine());	//학생 수
		
		for (int j=0; j<s; j++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());

			
			// 남자일때
			if (x==1) {
				man(y);
			}
			
			// 여자일때
			else if(x==2) {
				
				if(arr[y-1]==0) {
					arr[y-1]=1;
				}
				else if(arr[y-1]==1) {
					arr[y-1]=0;
				}
				woman(y-1);
				
			}
			
		}
		//한줄에 20개씩 출력
		for(int z=0; z<n; z++) {
			System.out.print(arr[z] + " ");
			if((z+1) % 20 == 0)
				System.out.println();
		}
		
	}
	
	//남자일 경우
	private static void man (int num) {
		//배수인 경우만 변경
		for (int i=0; i<n; i++) {
			if((i+1) % num ==0) {
				if(arr[i]==0) {
					arr[i]=1;
				}
				else if(arr[i]==1) {
					arr[i]=0;
				}
			}
		}
	}
	
	
	//여자일 경우
	private static void woman (int num) {
		
		// 대칭인거 체크 후스위치 변경
		for (int j=1; j<n/2; j++) {
			if(num-j<0 || num+j>=n) {
				break;
			}
			if (arr[num-j]==arr[num+j] ) {
				if(arr[num-j]==0) {
					arr[num-j]=1;
					arr[num+j]=1;
				}
				else if(arr[num-j]==1) {
					arr[num-j]=0;
					arr[num+j]=0;
				}
				
			}
			else {
				break;
			}
			
		}

	}

}