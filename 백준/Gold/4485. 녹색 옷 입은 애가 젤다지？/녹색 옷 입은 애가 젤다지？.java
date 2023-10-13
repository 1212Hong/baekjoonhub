import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  private static int N;

  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};

  private static int[][] maps;
  private static int[][] distances;

  static class Node implements Comparable<Node> {

    private int x, y, weight;

    public Node(int x, int y, int weight) {
      this.x = x;
      this.y = y;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int cnt = 1;
    while (true) {

      N = Integer.parseInt(br.readLine());
      if (N == 0) {
        break;
      }

      maps = new int[N][N];
      distances = new int[N][N];

      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          maps[i][j] = Integer.parseInt(st.nextToken());
          distances[i][j] = Integer.MAX_VALUE;
        }
      }
      int answer = bfs(0, 0);
      sb.append("Problem ").append(cnt).append(": ").append(answer).append("\n");
      cnt++;

    }
    System.out.println(sb);

  }


  private static int bfs(int startX, int startY) {
    distances[0][0] = maps[0][0];
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.add(new Node(startX, startY, maps[0][0]));

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int x = node.x;
      int y = node.y;

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (!isIn(nx, ny)) {
          continue;
        }

        if (distances[nx][ny] > distances[x][y] + maps[nx][ny]) {
          distances[nx][ny] = distances[x][y] + maps[nx][ny];
          queue.add(new Node(nx, ny, distances[nx][ny]));
        }

      }
    }

    return distances[N - 1][N - 1];

  }


  private static boolean isIn(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }

}