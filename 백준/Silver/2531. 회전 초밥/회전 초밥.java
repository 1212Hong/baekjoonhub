import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] eaten = new int[d + 1]; // 각 초밥 종류의 먹은 개수를 저장하는 배열
        int count = 0; // 현재 먹은 초밥 가짓수

        // 초기 연속된 초밥 k개에 대한 먹은 초밥 개수 계산
        for (int i = 0; i < k; i++) {
            if (eaten[belt[i]] == 0) {
                count++;
            }
            eaten[belt[i]]++;
        }

        int maxCount = count; // 최대 먹은 초밥 가짓수 초기화

        // 벨트를 한 칸씩 이동하면서 먹은 초밥 개수 업데이트
        for (int start = 0; start < N; start++) {
            int end = (start + k) % N; // 연속해서 먹는 범위의 끝 위치

            // 먹은 초밥 개수 업데이트
            if (eaten[belt[start]] == 1) {
                count--;
            }
            eaten[belt[start]]--;

            if (eaten[belt[end]] == 0) {
                count++;
            }
            eaten[belt[end]]++;

            // 쿠폰 초밥을 고려하여 최대 먹은 초밥 가짓수 갱신
            if (eaten[c] == 0) {
                maxCount = Math.max(maxCount, count + 1);
            } else {
                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.println(maxCount);
    }
}
