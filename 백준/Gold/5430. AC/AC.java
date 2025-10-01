import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        outts: for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            String content = line.substring(1, line.length() - 1);
            int[] input_list = content.isEmpty()
                    ? new int[0]
                    : Arrays.stream(line.substring(1, line.length() - 1).split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = 0, end = n - 1;
            boolean flag = true; // true면 그대로, false면 뒤집힌거
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    flag = !flag;
                } else {
                    if (start > end) {
                        bw.write("error\n");
                        continue outts;
                    }
                    if (flag) start++;
                    else end--;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (start <= end) {
                if (flag) {
                    for (int j = start; j < end; j++) sb.append(input_list[j]).append(',');
                    sb.append(input_list[end]);
                } else {
                    for (int j = end; j > start; j--) sb.append(input_list[j]).append(',');
                    sb.append(input_list[start]);
                }
            }
            sb.append("]").append("\n");

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}