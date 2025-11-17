import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    // true -> on, false -> off
    static boolean[] arr = new boolean[4004];

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) _1(b, c);
            if (a == 2) _2(b, c);
            if (a == 3) _3(b, c);
            if (a == 4) _4(b, c);
        }

        for (int i = 0; i < n; i++) {
            sb.append(arr[i] ? 1 : 0).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void _1(int i, int x) {
        arr[i-1] = x==1;
    }

    static void _2(int l, int r) {
        for (int i = l-1; i < r; i++) {
            arr[i] = !arr[i];
        }
    }

    static void _3(int l, int r) {
        for (int i = l-1; i < r; i++) {
            arr[i] = false;
        }
    }

    static void _4(int l, int r) {
        for (int i = l-1; i < r; i++) {
            arr[i] = true;
        }
    }
}
