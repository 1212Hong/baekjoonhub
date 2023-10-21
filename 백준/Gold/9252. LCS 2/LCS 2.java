import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    private static int[][] dp;

    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();

        dp = new int[c1.length + 1][c2.length + 1];


        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                
                if(c1[i-1]==c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else  {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }

        }

        sb.append(dp[c1.length][c2.length]).append("\n");
        solution(c1, c1.length, c2.length);

        System.out.println(sb);

    }

    private static void solution(char[] c, int i, int j){
        Stack<Character> stack = new Stack<>();

        while (i>0 && j>0){
            if(dp[i][j]==dp[i-1][j]){
                i--;
            } else if (dp[i][j]==dp[i][j-1]) {
                j--;
            }else {
                stack.add(c[i-1]);
                i--;
                j--;
            }

        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }


}