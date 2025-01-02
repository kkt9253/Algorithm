import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        while (true) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("0") && s[1].equals("0") && s[2].equals("0")) {
                break;
            }
            Arrays.sort(s, (a, b) -> {
                return Integer.parseInt(a) - Integer.parseInt(b);
            });
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if (c * c == a * a + b * b) bw.write("right\n");
            else bw.write("wrong\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}