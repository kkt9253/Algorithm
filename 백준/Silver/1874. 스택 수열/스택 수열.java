import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        int seq_now = 0;
        for (int i = 0; i < n; i++) {
            stk.push(i+1);
            sb.append("+\n");
            while (!stk.isEmpty() && stk.peek() == seq[seq_now]) {
                stk.pop();
                seq_now++;
                sb.append("-\n");
            }
        }

        if (stk.isEmpty()) bw.write(sb.toString());
        else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }
}