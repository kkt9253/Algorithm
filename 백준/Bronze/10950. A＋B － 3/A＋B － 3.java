import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            add(a, b, bw);
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void add(int a, int b, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(a+b));
        bw.newLine();
    }
}