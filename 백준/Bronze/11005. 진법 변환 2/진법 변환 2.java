import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        int b = Integer.parseInt(input[1]);

        Stack<Character> stack = new Stack<>();

        while (n > 0) {
            int remainder = (int) (n % b);
            if (remainder < 10) {
                stack.push((char) (remainder + '0'));
            } else {
                stack.push((char) (remainder - 10 + 'A'));
            }
            n /= b;
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}