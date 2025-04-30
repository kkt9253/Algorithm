import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringBuilder output = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            int cnt = 0;
            while (n > 0) {
                if (n % 2 == 1) {
                    output.append(String.valueOf(cnt)).append(' ');
                }
                n = n / 2;

                cnt++;
            }
            bw.write(output.toString() + '\n');
        }

        br.close();
        bw.flush();
        bw.close();
    }
}