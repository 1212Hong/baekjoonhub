import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int M, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            arr[i] = new ArrayList<>();

        }

        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);

        }

        int[] visited = new int[N+1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = 1;
        int cnt = 0;

        while(!q.isEmpty()){
            int curX = q.poll();
            visited[curX] = 1;

            for (int nX : arr[curX]){
                if(visited[nX]==1){
                    continue;
                }
                cnt++;
                q.add(nX);
                visited[nX]=1;
            }
        }

        System.out.println(cnt);

    }

}