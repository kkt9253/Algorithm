import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

class Main {

    public static int[] cnt_arr = new int[10];
    public static int t;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            Arrays.fill(cnt_arr, 0);
            int n = 0, m = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // idx, val
            Queue<SimpleEntry<Integer, Integer>> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                cnt_arr[k]++;
                q.offer(new SimpleEntry<>(j, k));
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                SimpleEntry<Integer, Integer> e = q.poll();

                boolean flag = false;
                for (int j = e.getValue()+1; j < 10; j++) {
                    if (cnt_arr[j] > 0) {
                        q.offer(e);
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                cnt++;
                if (e.getKey() == m) break;
                cnt_arr[e.getValue()]--;
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}