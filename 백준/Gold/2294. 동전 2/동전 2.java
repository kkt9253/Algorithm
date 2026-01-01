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

    static int INF = (int)1e9;
    static int[] dp = new int[10004];
    static int n, k;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Arrays.fill(dp, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(br.readLine());
            if (!arr.contains(j)) {
                arr.add(j);
            }
        }
        Collections.sort(arr);

        for (int i = 1; i <= k; i++) {
            for (Integer cv : arr) {
                if (i == cv) {
                    dp[i] = 1;
                    break;
                }
                if (i > cv && dp[i-cv] != INF) dp[i] = Math.min(dp[i-cv] + 1, dp[i]);
            }
        }

        if (dp[k] == INF) bw.write("-1\n");
        else bw.write(dp[k] + "\n");

        bw.close();
        br.close();
    }
}
