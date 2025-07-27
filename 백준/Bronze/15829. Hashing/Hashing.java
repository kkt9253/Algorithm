import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int m = 1234567891;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((input.charAt(i) - 'a' + 1) * (int) Math.pow(31, i));
        }

        bw.write(sum%m + "\n");
        bw.flush();
        bw.close();
    }
}