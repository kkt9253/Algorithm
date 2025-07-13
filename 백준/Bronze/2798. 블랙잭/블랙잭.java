import java.io.*;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> arr = new ArrayList<>();
    static int n, m, max;

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        s = null;
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(s[i]));
        }

        finish: for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = arr.get(i) + arr.get(j) + arr.get(k);
                    // m과 같으면 끝이니까 출력 후 종료
                    if (sum <= m && sum > max) {
                        max = sum;
                        if (sum == m) break finish;
                    }
                }
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}