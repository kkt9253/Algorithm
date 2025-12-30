import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int MAX = 1_000_000_000;
    static int a, b;

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int result = 0;
        while (b > a) {
            if ((b - 1) % 10 == 0) {
                b = (b - 1) / 10;
                result++;
                continue;
            }
            if (b % 2 != 0) {
                break;
            }
            b /= 2;
            result++;
        }
        if (b == a) {
            bw.write(result+1 + "\n");
        } else {
            bw.write("-1\n");
        }
        bw.close();
    }
}
