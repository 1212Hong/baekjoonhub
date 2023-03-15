import java.util.*;


class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Deque<String> deque = new ArrayDeque<String>();
		deque.add(words[0]);
		boolean flag = true;

		for (int i = 1; i < words.length; i++) {
			if (deque.contains(words[i])) {
				answer[0] =(i % n) + 1;
				answer[1] =(i / n) + 1;
				flag = false;
				break;
			}

			String before = deque.pollLast();
			char x = before.charAt(before.length() - 1);

			String after = words[i];
			char y = after.charAt(0);

			if (x != y) {
				answer[0] =(i % n) + 1;
				answer[1] =(i / n) + 1;
				flag = false;
				break;
			}

			deque.add(before);
			deque.add(after);
		}


        return answer;
    }
}