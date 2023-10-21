import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, X;

    private static ArrayList<Node>[] graph, revgraph;

    private static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        revgraph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            revgraph[i] = new ArrayList<>();

        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            revgraph[end].add(new Node(start, cost));


        }
        int[] origTime = dijkstra(graph);
        int[] revTime = dijkstra(revgraph);
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            int go = origTime[i];
            int back = revTime[i];

            answer = Math.max(answer, go + back);
        }
        System.out.println(answer);

    }

    private static int[] dijkstra(ArrayList<Node>[] checkGraph) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(X, 0));

        while (!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.poll();
            int curIndex = curNode.index;

            if (visited[curIndex]) {
                continue;
            }
            visited[curIndex] = true;

            for (Node next : checkGraph[curIndex]) {
                if (dist[next.index] > dist[curIndex] + next.cost) {
                    dist[next.index] = dist[curIndex] + next.cost;
                    priorityQueue.add(new Node(next.index, dist[next.index]));
                }

            }

        }

        return dist;

    }

}