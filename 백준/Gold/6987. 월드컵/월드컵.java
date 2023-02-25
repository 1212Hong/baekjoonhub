import java.util.Scanner;

public class Main {

  static int ans = 0;

  static void solution(int[][] group, int a, int b) {
    // 모든 경우의 수에서 0이 되는 배열이 하나라도 있다면 가능하다.
    if (check(group) == 1) {
      ans = 1;
    }
    for (int i = 0; i < 3; i++) {
      // 경기 하나씩 진행해본다.
      int na = a, nb = b + 1;
      if (nb == 6) {
        na = a + 1;
        nb = na + 1;
      }
      // 가능한 경기 탐색하고 백트래킹
      if (na < 6 && nb < 6) {
        if (group[na][i] > 0 && group[nb][2 - i] > 0) {
          group[na][i]--;
          group[nb][2 - i]--;
          solution(group, na, nb);
          group[na][i]++;
          group[nb][2 - i]++;
        }
      }
    }
  }

  // 모든 배열 값이 0이 된다면 트루
  public static int check(int[][] arr) {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 3; j++) {
        if (arr[i][j] > 0) {
          return 0;
        }
      }
    }
    return 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] group = null;
    for (int t = 0; t < 4; t++) {
      ans = 0;
      group = new int[6][3];
      // 인 풋 받아서
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 3; j++) {
          group[i][j] = sc.nextInt();
        }
      }
      // 모든 결과 탐색해보자
      solution(group, 0, 0);
      // 결과 출력
      System.out.println(ans);
    }

    sc.close();
  }
}
