import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dp = new int[10_004];
    static int n, m;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = (int) (Double.parseDouble(st.nextToken())*100 + 0.5);
            if (n == 0 && m == 0) break;

            Arrays.fill(dp, 0);
            // 0: 칼로리 , 1: 가격
            ArrayList<int[]> candies = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) (Double.parseDouble(st.nextToken())*100 + 0.5);
                candies.add(new int[]{c, p});
            }
            candies.sort((x, y) -> {
                if (x[1] != y[1]) {
                    return x[1] - y[1];
                }
                return y[0] - x[0];
            });

            for (int[] candy : candies) {
                for (int i = candy[1]; i <= m; i++) {
                    dp[i] = Math.max(dp[i], dp[i - candy[1]] + candy[0]);
                }
            }
            bw.write(dp[m] + "\n");
        }

        bw.close();
        br.close();
    }
}
