import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] p = new int[24];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.fill(p, -1);
        p[0] = 0;
        p[1] = 1;
        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(pibo(n)));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int pibo(int n) {
        if (p[n] == -1) {
            p[n] = pibo(n - 1 ) + pibo(n - 2);
        }
        return p[n];
    }
}