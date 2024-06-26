import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            swap(list, a, b);
        }

        bw.write(String.valueOf(list.get(0)));

        br.close();
        bw.flush();
        bw.close();
    }

    public static void swap(LinkedList<Integer> list, int a, int b) {
        int indexA = list.indexOf(a);
        int indexB = list.indexOf(b);

        list.set(indexA, b);
        list.set(indexB, a);
    }
}