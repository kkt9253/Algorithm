import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static class Problem {
        int deadLine;
        int cupRamen;

        public Problem(int deadLine, int cupRamen) {
            this.deadLine = deadLine;
            this.cupRamen = cupRamen;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        ArrayList<Problem> arr = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        arr.sort((x, y) -> {
            if (x.deadLine != y.deadLine) {
                return x.deadLine - y.deadLine;
            } else {
                return y.cupRamen - x.cupRamen;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        int result = 0;
        for (int i = 0; i < arr.size(); i++) {
            pq.offer(arr.get(i).cupRamen);
            result += arr.get(i).cupRamen;
            if (pq.size() > arr.get(i).deadLine) {
                result -= pq.poll();
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}
