import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Work implements Comparable<Work> {
        int comeT, money;

        Work(int money, int come) {
            comeT = come;
            this.money = money;
        }

        @Override
        public int compareTo(Work o) {
            if (this.comeT != o.comeT) {
                return this.comeT - o.comeT;
            }
            return o.money - this.money;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Work> pq1 = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq1.offer(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int result = 0;
        while (!pq1.isEmpty()) {
            Work cur = pq1.poll();
            pq2.offer(cur.money);
            result += cur.money;
            while (cur.comeT < pq2.size()) {
                result -= pq2.poll();
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}
