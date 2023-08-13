import java.io.*;
import java.util.*;

public class Main {
    static int M, N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] edgeCount = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            edgeCount[B]++;

        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            if (edgeCount[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int student = queue.poll();
            sb.append(student).append(" ");

            for (int i = 0; i < graph.get(student).size(); i++) {
                int temp = graph.get(student).get(i);

                edgeCount[temp]--;
                if (edgeCount[temp] == 0) {
                    queue.add(temp);
                }
            }
        }

        System.out.println(sb);
    }
}

