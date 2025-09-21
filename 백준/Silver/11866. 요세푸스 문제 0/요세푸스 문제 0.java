import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (q.size() > 1) {
            for (int i = 0; i < k-1; i++) q.offer(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
        br.close();
    }
}