import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] d = new int[1004];
    static int[][] dp = new int[1004][34];

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = d[0] == 1 ? 1 : 0;
        dp[0][1] = d[0] == 1 ? 0 : 1;

        for (int t = 1; t < n; t++) {
            for (int w = 0; w <= m; w++) {
                int tree = w%2+1;
                dp[t][w] = dp[t-1][w];
                if (w > 0) dp[t][w] = Math.max(dp[t][w], dp[t-1][w-1]);
                if (tree == d[t]) dp[t][w]++;
            }
        }

        int result = 0;
        for (int i = 0; i <= m; i++) {
            result = Math.max(result, dp[n-1][i]);
        }

        bw.write(result + "\n");
        bw.close();
    }
}
