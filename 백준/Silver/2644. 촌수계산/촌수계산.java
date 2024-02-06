import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, x, y, M;

    private static int result;

    private static ArrayList<ArrayList<Integer>> graphs;

    private static boolean[] checked;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 전체 사람 수 N

        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken()); // 촌수 계산 해야되는 x, y
        y = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine()); // 관계의 개수 M

        graphs = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graphs.add(new ArrayList<>());
        }

        checked = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphs.get(a).add(b);
            graphs.get(b).add(a);
        }

        DFS(x, y, 0);

        if(result == 0){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    private static void DFS(int start, int end, int cnt){
        if(start == end){
            result = cnt;
            return;
        }

        checked[start] = true;

        for (int i : graphs.get(start)){

            if (checked[i]){
                continue;
            }

            DFS(i, end, cnt+1);

        }


    }
}

