import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); ) {
            if (n % i == 0) {
                sb.append(i).append("\n");
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            sb.append(n).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}