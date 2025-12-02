import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        String s = br.readLine();
        Deque<Character> stk = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stk.push(s.charAt(i));
        }
        String boom = br.readLine();

        StringBuilder sb = new StringBuilder();
        int siz = s.length();
        while (siz-- > 0) {
            sb.append(stk.pop());
            if (sb.length() >= boom.length() &&
                    sb.substring(sb.length()-boom.length(), sb.length()).equals(boom)) {
                sb.delete(sb.length()-boom.length(), sb.length());
            }
        }
        if (sb.length() == 0)
            bw.write("FRULA");
        else {
            bw.write(sb.toString());
        }
        bw.close();
    }
}
