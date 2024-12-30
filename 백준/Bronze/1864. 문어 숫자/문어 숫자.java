import java.io.*;
import java.util.Objects;

public class Main {

    public static int solve(char input) {
        if (input == '-') return 0;
        else if (input == '\\') return 1;
        else if (input == '(') return 2;
        else if (input == '@') return 3;
        else if (input == '?') return 4;
        else if (input == '>') return 5;
        else if (input == '&') return 6;
        else if (input == '%') return 7;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals("#")) break;
            int val = 0;
            for (int i = 0; i < s.length(); i++) {
                int n = solve(s.charAt(i));
                val += (int) (n * Math.pow(8, (s.length() - i - 1)));
            }
            bw.write(String.valueOf(val) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}