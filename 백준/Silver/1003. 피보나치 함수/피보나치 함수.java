import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int _max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(Integer.parseInt(br.readLine()));
            if (list.get(i) > _max) _max = list.get(i);
        }
        int[][] output = new int[44][2];
        for (int i = 0; i < 44; i++) {
            Arrays.fill(output[i], -1);
        }
        output[0][0] = 1; output[0][1] = 0;
        output[1][0] = 0; output[1][1] = 1;

        for (int i = 2; i <= _max; i++) {
            output[i][0] = output[i - 1][0] + output[i - 2][0];
            output[i][1] = output[i - 1][1] + output[i - 2][1];
        }

        for (Integer i : list) {
            bw.write(output[i][0] + " " + output[i][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}