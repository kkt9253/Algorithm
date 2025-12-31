import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int INF = (int)1e9;
    static int[] dp = new int[(int)1e6+4];
    static int[] dp2 = new int[(int)1e6+4];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        Arrays.fill(dp, INF);

        int n = Integer.parseInt(br.readLine());

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            dp2[i] = i-1;

            if (i % 2 == 0 && dp[i/2] + 1 < dp[i]) {
                dp[i] = dp[i/2] + 1;
                dp2[i] = i/2;
            }

            if (i % 3 == 0 && dp[i/3] + 1 < dp[i]) {
                dp[i] = dp[i/3] + 1;
                dp2[i] = i/3;
            }
        }

        sb.append(dp[n]).append("\n");
        while (n != 0) {
            sb.append(n).append(" ");
            n = dp2[n];
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
