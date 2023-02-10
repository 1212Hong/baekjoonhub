import java.io.*;
import java.util.*;

public class Solution {
	
	private static int test_case;

	public static void main(String args[]) throws Exception
	{

//	System.setIn(new FileInputStream("src/input.txt"));
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int T = 10;

	for(test_case = 1; test_case <= T; test_case++)
	{
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		Deque<Character> deq = new ArrayDeque<>();
		
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		map.put('>', '<');
		
		boolean checked = true;
		
		//문자열 하나씩 받아서 deq로
		for (int i=0; i<n; i++) {
			char x = s.charAt(i);
			//괄호 시작이면 deq에 넣는다
			if ( x=='(' || x=='[' || x== '{' || x=='<') {
				deq.add(x);
			}
			//닫는 괄호일 경우
			else {
				//deq가 비어있으면 맞지않는 경우이므로 false
				if(deq.isEmpty()) {
					checked = false;
					break;
				}
				//deq에 값 있는경우
				else {
					//deq에 들어있는 마지막 값의 시작괄호와 닫는 괄호가 매칭이 된다면 deq에 있는 시작괄호를 없애준다
					if(deq.removeLast()==map.get(x)) {//deq 가장 뒤 요소 삭제
					}
					//맞지 않는 괄호이면 false
					else {
						checked = false;
						break;
					}
				}
			}
		}
		
		// 시작괄호가 남아있으면 false
		if (!deq.isEmpty()) {
			checked = false;
		}
		
		if (checked) {
			System.out.println("#" + test_case + " " + 1);
		}
		else {
			System.out.println("#" + test_case + " " + 0);
		}
		
	}
	
	}
	
	}
