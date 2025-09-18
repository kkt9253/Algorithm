import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;


class Main {

    static int factorial(int n) {
        int sum = 1;
        for (int i = 1; i < n + 1; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int val = factorial(n) / (factorial(k) * factorial(n - k));
        bw.write(val + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}