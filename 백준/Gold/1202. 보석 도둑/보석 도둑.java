import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] times, degrees;
    private static int[] bags;

    private static Jewels[] jewel;


    private static class Jewels {
        int M, V;

        public Jewels(int v, int m) {
            this.V = v;
            this.M = m;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewel = new Jewels[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());   // 무게
            int V = Integer.parseInt(st.nextToken());   // 가격

            jewel[i] = new Jewels(V, M);

        }

        Arrays.sort(jewel, (j1, j2) -> {
            if (j1.M == j2.M) return j2.V - j1.V;
            return j1.M - j2.M;
        });

        bags = new int[K];

        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());

            bags[i] = C;
        }
        Arrays.sort(bags);

        solutions();

    }

    private static void solutions() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;

        for (int i = 0, j = 0; i < K; i++) {

            while (j < N && jewel[j].M <= bags[i]) {
                pq.offer(jewel[j].V);
                j++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }

        }

        System.out.println(answer);


    }

}