import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nan = new int[9];
        int fake1 = 0, fake2 = 0;
        int sum = 0;
        boolean found = false;

        for (int i = 0; i < 9; i++) {
            nan[i] = Integer.parseInt(br.readLine());
            sum += nan[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (nan[i] + nan[j] == sum - 100) {
                    fake1 = nan[i];
                    fake2 = nan[j];
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        for (int i : nan) {
            if (i == fake1 || i == fake2) {
                continue;
            }
            bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}