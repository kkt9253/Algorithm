import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);

        boolean[] arr = new boolean[b+4];
        arr[1] = true;
        for (int i = 2; i*i <= b; i++) {
            if (arr[i]) continue;
            for (int j = i*i; j <= b; j += i) {
                arr[j] = true;
            }
        }

        for (int i = a; i <= b; i++) {
            if (!arr[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}