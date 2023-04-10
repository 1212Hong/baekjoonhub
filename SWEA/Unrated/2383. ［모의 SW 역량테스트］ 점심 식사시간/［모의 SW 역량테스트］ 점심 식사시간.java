import java.io.*;
import java.util.*;

import javax.print.attribute.HashAttributeSet;

/**
 * 1. 계단 배정(PowerSet) 2. 계단별 사람리스트를 만들기 - 맨하탄거리 이용해서 계단 도착시간 계산 3. 사람리스트 도착시간
 * 빠른순으로 정렬 4. 시작시간 : 첫사람 도착시간 5. 모든 사람에 대해 시간별 처리 - 해당 사람 도착시간이 time과 일치 ->
 * 도착상태인 사람. 1분 대기처리
 * 
 * - 해당 사람 도착상태사람. 내려가고 있는사람 < 3 -> 내려가는 상태 사람.내려가는 계단수 카운트. 내려가고있는 사람수 증가
 * 
 * - 해당 사람 내려가고있는 사람 - >내려간 계단수==계단길이 - 이동완료사람, 내려가고 있는 사람수 감소, 완료 사람수 증가
 *
 *
 */

public class Solution {
	static int N, cnt, answer;
	static int[][] sList;

	static int[] selected;

	static ArrayList<Person> pList;

	static final int M = 1, W = 2, D = 3, C = 4; // 이동중, 대기, 내려가는중, 완료

	static class Person implements Comparable<Person> {

		int x, y, arrivalTime, downCnt, status;

		public Person(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public void init() {
			arrivalTime = downCnt = 0;
			status = M;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			pList = new ArrayList<Person>();
			sList = new int[2][];

			// 입력받기
			for (int i = 0, k = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						pList.add(new Person(i, j));
					} else if (x >= 2) {
						sList[k++] = new int[] { i, j, x };
					}
				}
			}

			cnt = pList.size();
			selected = new int[cnt]; // 선택한 계단 인덱스

			answer = Integer.MAX_VALUE;
			// 모든 사람에게 계단 배정
			divide(0);

			sb.append("#").append(tc).append(" ").append(answer + "\n");

		}
		System.out.println(sb);

	}

	// power set
	private static void divide(int index) {
		if (index == cnt) {
			int res = go();

			answer = Math.min(answer, res);
			return;
		}

		// 계단0 선택
		selected[index] = 0;
		divide(index + 1);

		// 계단1 선택
		selected[index] = 1;
		divide(index + 1);
	}

	// 선택된 계단에 따라 사람들의 리스트 만들고 내려가기 처리 후 소요된 시간 리턴
	private static int go() {

		ArrayList<Person>[] list = new ArrayList[] { new ArrayList<Person>(), new ArrayList<Person>() };

		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			p.init(); // 사람의 상태를 초기화

			int no = selected[i];
			p.arrivalTime = Math.abs(p.x - sList[no][0]) + Math.abs(p.y - sList[no][1]);
			list[no].add(p);
		}

		int timeA = 0, timeB = 0;
		if (list[0].size() > 0) {
			timeA = processDown(list[0], sList[0][2]);
		}
		if (list[1].size() > 0) {
			timeB = processDown(list[1], sList[1][2]);
		}

		return timeA > timeB ? timeA : timeB;
	}

	private static int processDown(ArrayList<Person> list, int height) {

		Collections.sort(list); // 계단 입구까지 도착시간이 빠른순으로 정렬

		int time = list.get(0).arrivalTime; // 먼저 도착한 사람의 시간부터 흘러가게 함
		int size = list.size();

		int ingCnt = 0, cCnt = 0; // 내려가는 사람수, 완료 사람수
		Person p = null;

		while (true) {

			for (int i = 0; i < size; i++) {
				p = list.get(i);

				if (p.status == C) {
					continue;
				} else if (p.arrivalTime == time) {
					p.status = W;
				} else if (p.status == W && ingCnt < 3) {
					p.status = D;
					p.downCnt = 1;
					ingCnt++;
				} else if (p.status == D) {
					if (p.downCnt == height) {
						p.status = C;
						ingCnt--;
						cCnt++;
					} else {
						p.downCnt++;
					}
				}
			} // 해당 시간에 모든 사람에 대해 처리

			if (cCnt == size) {
				break;
			}
			time += 1;

		}

		return time;
	}
}
