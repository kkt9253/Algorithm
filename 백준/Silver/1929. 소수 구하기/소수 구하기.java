import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n+4];
        // true: 소수, false: 소수 X
        Arrays.fill(arr, true);

        // 0과 1은 소수가 아님
        arr[0] = false;
        arr[1] = false;

        // a*b일 때 (a < b)라면 a < sqrt(m)이기 때문에 아래의 범위로 탐색
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 현재가 소수면 배수들 삭제
            if (arr[i]) {
                // i*i 이전 값들은 이미 배수 처리가 되었기 때문에 i*i부터
                for (int j = i*i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (arr[i]) sb.append(i).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}