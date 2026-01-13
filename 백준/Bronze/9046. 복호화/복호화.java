import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k;
    static int[] dp = new int[10004];

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] arr = new int[30];
            int mx = 0;

            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == ' ') continue;
                arr[c - 'a']++;
                mx = Math.max(mx, arr[c - 'a']);
            }
            ArrayList<Character> al = new ArrayList<>();
            for (int j = 0; j < 26; j++) {
                if (mx == arr[j]) al.add((char) ('a' + j));
            }
            if (al.size() != 1) {
                bw.write("?\n");
                continue;
            }
            bw.write(al.get(0) + "\n");
        }

        bw.close();
        br.close();
    }
}
