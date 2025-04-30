import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int cnt = 0;
        int output = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (cnt == k) {
                    output = i;
                    break;
                }
            }
        }

        bw.write(String.valueOf(output));

        br.close();
        bw.flush();
        bw.close();
    }
}