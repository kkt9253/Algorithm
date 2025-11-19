import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        if (n == 1 || n == 3) {
            bw.write(-1 + "\n");
            bw.flush();
            return;
        }
        int nok = n / 5;
        int na = n % 5;
        while (na % 2 != 0) {
            nok--;
            na += 5;
        }
        int result = na / 2;
        result += nok;

        bw.write(result + "\n");
        bw.flush();
    }
}
