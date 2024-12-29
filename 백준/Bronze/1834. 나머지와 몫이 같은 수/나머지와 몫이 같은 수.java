import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 1; i < n; i++) {
            sum += n * i + i;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}