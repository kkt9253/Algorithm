import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int m = 1234567891;
        int r = 31;

        long sum = 0;
        long power = 1;
        for (int i = 0; i < n; i++) {
            int value = input.charAt(i) - 'a' + 1;
            sum = (sum + value * power) % m;
            power = (power * r) % m;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}