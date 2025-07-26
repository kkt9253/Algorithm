import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);

        if (n >= 3) dp[3] = 1;
        if (n >= 5) dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (dp[i - 3] != INF)
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if (dp[i - 5] != INF)
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        if (dp[n] == INF) bw.write("-1\n");
        else bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
    }
}