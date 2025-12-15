import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] arr = new int[16][16];
    // 3차원: 0-가로, 1-세로, 2-대각선
    static int[][][] dp = new int[16][16][3];

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 기본값
        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (arr[i][j] == 1) continue;

                // 가로
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                if (i == 0) continue;
                //세로
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                // 대각선
                if (arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }

        int result = dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];

        bw.write(result + "\n");
        bw.close();
    }
}