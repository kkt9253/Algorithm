import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int min = Integer.MAX_VALUE;
    static char[][] arr = new char[54][54];

    static void solve(int y, int x) throws IOException {
        int cnt = 0;

        char cur = arr[y][x];
        for (int i = y; i < y+8; i++) {
            for (int j = x; j < x+8; j++) {
                char changeC;
                if ((i+j)%2 == 0) changeC = cur;
                else changeC = (cur == 'W' ? 'B' : 'W');

                if (arr[i][j] != changeC) cnt++;
            }
        }
        cnt = Math.min(cnt, 64 - cnt);
        if (min > cnt) min = cnt;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                solve(i, j);
            }
        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}