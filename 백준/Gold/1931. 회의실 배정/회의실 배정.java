import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Work implements Comparable<Work> {
        int start, end;

        public Work(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Work o) {
            if (this.end != o.end) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Work> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int result = 0, tl = 0;
        while (!pq.isEmpty()) {
            Work cur = pq.poll();
            if (tl <= cur.start) {
                tl = cur.end;
                result++;
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}