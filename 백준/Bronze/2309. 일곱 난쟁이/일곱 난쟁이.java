import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int[] a = new int[9];
    static ArrayList<Integer> ar = new ArrayList<>();
    static int ret = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        solve(0, 0);

        br.close();
    }

    public static void solve(int idx, int sum) {
        if (ret == 100) return;
        if (ar.size() == 7) {
            if (sum == 100) {
                ret = 100;
                for (Integer i : ar) {
                    System.out.println(i);
                }
            }
            return;
        }
        if (idx >= 9) return;

        ar.add(a[idx]);
        solve(idx + 1, sum + a[idx]);
        ar.remove(ar.size() - 1);

        solve(idx + 1, sum);
    }
}