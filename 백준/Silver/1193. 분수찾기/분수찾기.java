import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int col = 1, row = 1;

        int movCnt = 1;
        int cnt = 1; // 대각선 카운트


        while (true) {
            if (movCnt == n) break;
            // -> 1번 이동
            row++; movCnt++;

            // 좌측 하단 cnt번 이동
            for (int j = 0; j < cnt; j++) {
                if (movCnt == n) break;
                row--;
                col++;
                movCnt++;
            } cnt++;

            if (movCnt == n) break;
            // 하단 1번 이동
            col++; movCnt++;

            // 우측 상단 cnt번 이동
            for (int j = 0; j < cnt; j++) {
                if (movCnt == n) break;
                row++;
                col--;
                movCnt++;
            } cnt++;

        }
        sb.append(col).append("/").append(row).append("\n");
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}