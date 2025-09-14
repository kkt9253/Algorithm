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
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Node o) {
        if (this.x != o.x) return this.x - o.x;
        return this.y - o.y;
    }
}

class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Node> nodes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(nodes);

        for (Node node : nodes) {
            System.out.println(node.getX() + " " + node.getY());
        }
    }
}