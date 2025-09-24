import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        // k는 그대로, n은 +1
        int[][] arr = new int[15][15];

        for (int i = 1; i <= 14; i++) {
            arr[0][i] = i;
        }
        for (int i = 1; i <= 14; i++) {
            // (idx:0) 1호는 어차피 다 1명이라 제외
            for (int j = 1; j <= 14; j++) {
                if (j==1) arr[i][j] = 1;
                else arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(arr[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}