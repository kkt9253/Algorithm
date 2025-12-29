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
    static int m;
    static char[][] arr = new char[54][54];
    static int[][] dp = new int[54][54];
    static boolean[][] visited = new boolean[54][54];
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean inf = false;

    static int go(int sy, int sx) {
        if (sy < 0 || n <= sy || sx < 0 || m <= sx || arr[sy][sx] == 'H') {
            return 0;
        }
        if (visited[sy][sx]) {
            inf = true;
            return 0;
        }
        if (dp[sy][sx] != -1) return dp[sy][sx];

        visited[sy][sx] = true;
        int move = arr[sy][sx] - '0';
        dp[sy][sx] = 0;
        for (int i = 0; i < 4; i++) {
            dp[sy][sx] = Math.max(dp[sy][sx], go(sy + dy[i]*move, sx + dx[i]*move)+1);
        }
        visited[sy][sx] = false;
        return dp[sy][sx];
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int result = go(0, 0);
        if (inf) bw.write(-1 + "\n");
        else bw.write(result + "\n");
        bw.close();
    }
}
