import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int result;
    static int[] cow = new int[10];

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        Arrays.fill(cow, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cowN = Integer.parseInt(st.nextToken());
            int cowP = Integer.parseInt(st.nextToken());
            // 소 위치 추가된 상태인데
            if (cow[cowN-1] != -1) {
                // 위치가 바꼈다면
                if (cow[cowN-1] != cowP) {
                    cow[cowN - 1] = cowP;
                    result++;
                }
            } else {
                cow[cowN - 1] = cowP;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
