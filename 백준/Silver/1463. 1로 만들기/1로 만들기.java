import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] dp = new int[1000004];

    static final int MAX = (int) 1e9;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp[0] = 0; dp[1] = 0; dp[2] = 1; dp[3] = 1;
        
        if (n < 4) {
            bw.write(String.valueOf(dp[n]));
            bw.flush();
            return;
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(
                    dp[i-1],
                    Math.min(
                            i%3 == 0 ? dp[i/3] : MAX,
                            i%2 == 0 ? dp[i/2] : MAX
                    )
            ) + 1;
        }

        bw.write(String.valueOf(dp[n]));

        bw.flush();
    }
}
