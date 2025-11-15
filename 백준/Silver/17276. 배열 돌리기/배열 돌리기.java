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

    static int t;
    static int[][] arr = new int[504][504];

    public static void main(String[] args) throws IOException {

        //StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            if (d == 0 || d == 360 || d == -360) {
                print(n);
                continue;
            }
            if (d > 0) {
                rotation45P(d / 45, n);
            } else {
                rotation45M(Math.abs(d) / 45, n);
            }
            print(n);
        }
    }

    static void rotation45P(int cnt, int siz) {

        while (cnt-- != 0) {
            int[][] temp = new int[siz][siz];

            for (int i = 0; i < siz; i++) {
                temp[i][siz/2] = arr[i][i];
                temp[i][siz-i-1] = arr[i][siz/2];
                temp[siz/2][i] = arr[siz-i-1][i];
                temp[i][i] = arr[siz/2][i];
            }

            for (int i = 0; i < siz; i++) {
                for (int j = 0; j < siz; j++) {
                    arr[i][j] = temp[i][j] == 0 ? arr[i][j] : temp[i][j];
                }
            }
        }
    }

    static void rotation45M(int cnt, int siz) {

        while (cnt-- != 0) {
            int[][] temp = new int[siz][siz];

            for (int i = 0; i < siz; i++) {
                temp[siz / 2][i] = arr[i][i];
                temp[i][i] = arr[i][siz / 2];
                temp[siz-i-1][siz / 2] = arr[siz-i-1][i];
                temp[siz - i - 1][i] = arr[siz / 2][i];
            }

            for (int i = 0; i < siz; i++) {
                for (int j = 0; j < siz; j++) {
                    arr[i][j] = temp[i][j] == 0 ? arr[i][j] : temp[i][j];
                }
            }
        }
    }

    static void print(int siz) {
        for (int i = 0; i < siz; i++) {
            for (int j = 0; j < siz; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
