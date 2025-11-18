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
    static StringBuilder sb = new StringBuilder();

    static int t;
    static boolean[][] arr = new boolean[3][3];
    static int INF = (int) 1e9;
    static int result = INF;
    static int[][] dc =
            {
                    {0, 0, 0, 1, 0, 2},
                    {1, 0, 1, 1, 1, 2},
                    {2, 0, 2, 1, 2, 2},

                    {0, 0, 1, 0, 2, 0},
                    {0, 1, 1, 1, 2, 1},
                    {0, 2, 1, 2, 2, 2},

                    {0, 0, 1, 1, 2, 2},
                    {0, 2, 1, 1, 2, 0}
            };

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            result = INF;
            for (int i = 0; i < 3; i++) {
                Arrays.fill(arr[i], false);
            }

            StringTokenizer st;
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = st.nextToken().equals("H");
                }
            }

            solve(0, 0);
            bw.write((result==INF ? -1 : result) + "\n");
        }
        bw.flush();
    }

    static void solve(int cnt, int idx) {
        if (check()) {
            result = Math.min(cnt, result);
            return;
        }
        if (result <= cnt) return;
        if (idx == 8) return;

        for (int i = idx; i < 8; i++) {
            int[] f = {dc[i][0], dc[i][1]};
            int[] s = {dc[i][2], dc[i][3]};
            int[] t = {dc[i][4], dc[i][5]};

            chang(f, s, t);

            solve(cnt+1, idx+1);

            chang(f, s, t);
        }
    }

    static void chang(int[] f, int[] s, int[] t) {
        arr[f[0]][f[1]] = !arr[f[0]][f[1]];
        arr[s[0]][s[1]] = !arr[s[0]][s[1]];
        arr[t[0]][t[1]] = !arr[t[0]][t[1]];
    }

    static boolean check() {
        boolean chk = arr[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] != chk) return false;
            }
        }
        return true;
    }
}
