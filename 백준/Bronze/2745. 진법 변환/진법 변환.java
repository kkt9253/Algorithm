import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int m;

    public static int convertValue(char c, int idx) {
        if ('0' <= c && c <= '9') {
            return ((c - '0') * (int) Math.pow(m, idx));
        }
        int val = (int) c - (int) 'A' + 10;
        return (val * (int) Math.pow(m, idx));
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        m = Integer.parseInt(st.nextToken());
        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            int idx = n.length() - i - 1;
            sum += convertValue(n.charAt(idx), i);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}