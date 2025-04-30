import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0, current = 0;
        for (int i = 0; i < 10; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            current = current - x + y;
            if (max < current) {
                max = current;
            }
        }
        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}