import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) st.pop();
            else st.push(input);
        }
        int sum = 0;
        for (Integer i : st) sum += i;
        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}