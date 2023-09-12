import java.io.*;
import java.util.*;

public class Main {
    private static Deque<Integer> deque;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {

            char[] arr = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true; // 정방향
            boolean chk = true;

            for (char c : arr) {
                if (c == 'R') {
                    flag = !flag;
                } else {
                    if (deque.isEmpty()) {
                        chk = false;
                        sb.append("error").append("\n");
                        break;
                    }
                    if (flag) { // 정방향
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }
            if (chk) {
                if (deque.isEmpty()) {
                    sb.append("[]").append("\n");
                } else {
                    sb.append("[");
                    int qSize = deque.size();
                    if (flag) {
                        for (int j = 0; j < qSize - 1; j++) {
                            sb.append(deque.removeFirst()).append(",");
                        }
                        sb.append(deque.removeFirst());
                    } else {
                        for (int j = 0; j < qSize - 1; j++) {
                            sb.append(deque.removeLast()).append(",");
                        }
                        sb.append(deque.removeLast());
                    }
                    sb.append("]").append("\n");
                }
            }


        }
        System.out.println(sb);
    }
}