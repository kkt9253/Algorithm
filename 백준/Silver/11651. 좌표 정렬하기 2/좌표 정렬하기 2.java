import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(Node o) {
        if (this.y != o.y) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            list.add(new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        list.forEach(node -> {
            sb.append(node.getX()).append(" ").append(node.getY()).append("\n");
        });

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}