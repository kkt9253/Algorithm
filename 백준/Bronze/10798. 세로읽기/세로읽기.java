import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void go(String s, int siz) {
        if (s.length() >= siz + 1) {
            sb.append(s.charAt(siz));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = new String[5];
        int mx = 0;
        for (int i = 0; i < 5; i++) {
            s[i] = br.readLine();
            mx = Math.max(mx, s[i].length());
        }

        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < 5; j++) {
                go(s[j], i);
            }
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}
