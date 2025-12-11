import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Cow implements Comparable<Cow> {
        int comeT, workT;

        Cow(int come, int work) {
            comeT = come;
            workT = work;
        }

        @Override
        public int compareTo(Cow o) {
            if (this.comeT != o.comeT) {
                return this.comeT - o.comeT;
            }
            return o.workT - this.workT;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Cow> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int t = 0;
        while (!pq.isEmpty()) {
            Cow cur = pq.poll();

            if (t >= cur.comeT) {
                t += cur.workT;
            } else {
                t = cur.comeT + cur.workT;
            }
        }

        bw.write(t + "\n");
        bw.close();
    }
}
