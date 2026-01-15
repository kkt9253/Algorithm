import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int INF = (int) 1e9;
    static int[][] arr = new int[10][10];
    static int n = 10, ret = INF;
    static int[] map = new int[6];

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (ret == INF)
            bw.write("-1\n");
        else
            bw.write(ret + "\n");

        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int cnt) {
        if (cnt >= ret) return;
        if (x == n) {
            dfs(y + 1, 0, cnt);
            return;
        }
        if (y == n) {
            ret = Math.min(ret, cnt);
            return;
        }
        if (arr[y][x] == 0) {
            dfs(y, x + 1, cnt);
            return;
        }

        for (int i = 5; i >= 1; i--) {
            if (map[i] < 5 && check(y, x, i)) {
                map[i]++;
                draw(y, x, i, 0);
                dfs(y, x+i, cnt+1);
                map[i]--;
                draw(y, x, i, 1);
            }
        }
    }

    private static void draw(int y, int x, int siz, int val) {
        for (int i = y; i < y+siz; i++) {
            for (int j = x; j < x+siz; j++) {
                arr[i][j] = val;
            }
        }
    }

    static boolean check(int y, int x, int siz) {
        if (y + siz > n || x + siz > n) return false;
        for (int i = y; i < y+siz; i++) {
            for (int j = x; j < x+siz; j++) {
                if (arr[i][j] == 0) return false;
            }
        }
        return true;
    }
}