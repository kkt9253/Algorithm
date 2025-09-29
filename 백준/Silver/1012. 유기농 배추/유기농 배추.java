import java.io.*;
import java.util.*;

class Node {
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
}

class Main {

    static int[][] graph = new int[54][54];
    static int[][] visited = new int[54][54];
    static int m, n, k;

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static void dfs(int cur_x, int cur_y) {
        visited[cur_x][cur_y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (visited[nx][ny] > 0) continue;
            if (graph[nx][ny] >= 1) dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) Arrays.fill(graph[j], 0);
            for (int j = 0; j < n; j++) Arrays.fill(visited[j], 0);

            ArrayList<Node> nodes = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes.add(new Node(x, y));
                graph[x][y] = 1;
            }

            int cnt = 0;
            for (Node node : nodes) {
                if (visited[node.getX()][node.getY()] == 0) {
                    dfs(node.getX(), node.getY());
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}