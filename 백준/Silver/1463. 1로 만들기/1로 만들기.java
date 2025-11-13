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
        Arrays.fill(dp, -1);
        dp[0] = 0; dp[1] = 0; dp[2] = 1; dp[3] = 1;

        bw.write(String.valueOf(solve(n)));

        br.close();
        bw.flush();
        bw.close();
    }

    static int solve(int nn) {
        if (nn <= 1) {
            return 0;
        }
        if (dp[nn] != -1) {
            return dp[nn];
        }

        int a = MAX, b = MAX, c = MAX;
        if (nn % 3 == 0) {
            a = solve(nn / 3);
        }
        if (nn % 2 == 0) {
            b = solve(nn / 2);
        }
        c = solve(nn - 1);

        return dp[nn] = Math.min(a, Math.min(b, c)) + 1;
    }
}
