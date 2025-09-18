import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;


class Main {

    static Deque<Integer> deque = new ArrayDeque<>();

    static void push(int a) {
        deque.offerLast(a);
    }

    static int pop() {
        Integer a = deque.pollFirst();
        return a == null ? -1 : a;
    }

    static int size() {
        return deque.size();
    }

    static int empty() {
        return deque.isEmpty() ? 1 : 0;
    }

    static int front() {
        return deque.peekFirst() == null ? -1 : deque.peekFirst();
    }

    static int back() {
        return deque.peekLast() == null ? -1 : deque.peekLast();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String a = inputs[0];
            int b = 0;
            if (inputs.length == 2) b = Integer.parseInt(inputs[1]);

            StringBuilder sb = new StringBuilder();
            if (a.equals("push")) push(b);
            else if (a.equals("pop")) sb.append(pop()).append("\n");
            else if (a.equals("size")) sb.append(size()).append("\n");
            else if (a.equals("empty")) sb.append(empty()).append("\n");
            else if (a.equals("front")) sb.append(front()).append("\n");
            else if (a.equals("back")) sb.append(back()).append("\n");

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}