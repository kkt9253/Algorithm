import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int INF = (int) 1e9;
    static int n;
    static int[][] w = new int[16][16];
    static int[][] dp = new int[16][1<<16];

    static int tsp(int here, int visited) {
        if (visited == (1<<n)-1) {
            return w[here][0] != 0 ? w[here][0] : INF;
        }
        if (dp[here][visited] != -1) {
            return dp[here][visited];
        }
        dp[here][visited] = INF;

        for (int i = 0; i < n; i++) {
            if ((visited & 1 << i) > 0) {
                continue;
            }
            if (w[here][i] == 0) {
                continue;
            }
            dp[here][visited] = Math.min(dp[here][visited], tsp(i, visited | 1 << i) + w[here][i]);
        }
        return dp[here][visited];
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(tsp(0, 1) + "\n");
        bw.close();
    }
}