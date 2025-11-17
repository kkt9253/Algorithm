import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m, cnt;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[1004];

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // create node
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // link edge
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    static void bfs(int node) {
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int curNode = q.poll();
            for (int linkNode : graph.get(curNode)) {
                if (!visited[linkNode]) {
                    visited[linkNode] = true;
                    q.offer(linkNode);
                }
            }
        }
    }
}
