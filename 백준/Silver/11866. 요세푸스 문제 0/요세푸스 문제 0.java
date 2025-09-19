import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (q.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll());

        sb.append(">");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}