import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long n = Integer.parseInt(br.readLine());
        long start = 2;
        long val = 1;

        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (n < start) break;

            val++;
            start += i * 6L - 6;
        }
        bw.write(String.valueOf(val));

        bw.flush();
        bw.close();
        br.close();
    }
}