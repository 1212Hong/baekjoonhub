import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String orig = br.readLine();
        String bomb = br.readLine();

        int origLen = orig.length();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < origLen; i++) {
            char c = orig.charAt(i);
            stack.add(c);
            if (stack.size() >= bombLen) {
                boolean flag = true;
                for (int j = 0; j < bombLen; j++) {
                    char x = stack.get(stack.size() - bombLen + j);
                    char y = bomb.charAt(j);

                    if (x != y) {
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    for (int z = 0; z < bombLen; z++) {
                        stack.pop();
                    }
                }

            }

        }

        if (stack.size()==0) {
            System.out.println("FRULA");
        } else {
            for (Character cc : stack) {
                sb.append(cc);
            }
            System.out.println(sb);
        }

    }

}