import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int sum;

    public static void main(String[] args) throws IOException {

        while (true) {
            String in = br.readLine();
            if (in.equals("-1")) break;
            int inNum = Integer.parseInt(in);

            // 초기화
            sb.setLength(0);
            sum = 1;
            // 초기값
            sb.append(in).append(" = 1");

            for (int i = 2; i <= inNum/2+1; i++) {
                // 약수일 때
                if (inNum % i == 0) {
                    sum += i;
                    sb.append(" + ").append(i);
                }
            }

            if (sum == inNum) bw.write(sb.toString() + "\n");
            else bw.write(inNum + " is NOT perfect.\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}