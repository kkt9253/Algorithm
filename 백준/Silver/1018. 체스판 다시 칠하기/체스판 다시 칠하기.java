import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int min = Integer.MAX_VALUE;
    static char[][] arr = new char[54][54];

    static void solve(int y, int x, char c) {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 짝
                if (i%2 == 0) {
                    if (j%2 == 0) {
                        if (arr[i+y][j+x] != c) cnt++;
                    } else {
                        if (arr[i+y][j+x] == c) cnt++;
                    }
                }
                // 홀
                else {
                    if (j%2 == 0) {
                        if (arr[i+y][j+x] == c) cnt++;
                    } else {
                        if (arr[i+y][j+x] != c) cnt++;
                    }
                }
            }
        }
        if (min > cnt) min = cnt;
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // row
        int m = Integer.parseInt(s[1]); // col

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                solve(i, j, 'W');
                solve(i, j, 'B');
            }
        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}