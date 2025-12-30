import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long[][] dp = new long[34][34];

    static long go(int whole, int half) {
        if (half < 0) {
            return 0;
        }
        if (whole == 0) {
            dp[whole][half] = 1;
            return 1;
        }
        if (dp[whole][half] != -1) {
            return dp[whole][half];
        }

        long h = go(whole, half - 1);
        long w = go(whole - 1, half+1);

        return dp[whole][half] = h+w;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // 어차피 다른 TC에 대해서도 dp는 동일하기 때문에 TC마다 초기화할 필요 X
        for (int i = 0; i < 34; i++) {
            Arrays.fill(dp[i], -1);
        }

        while (true) {
            int line = Integer.parseInt(br.readLine());
            if (line == 0) {
                break;
            }

            sb.append(go(line, 0)).append("\n");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
