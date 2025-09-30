import java.io.*;
import java.util.*;

class Main {

    static StringBuilder sb = new StringBuilder();

    static int n, m, v;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int node) {
        sb.append(node).append(" ");
        visited[node] = true;

        for (Integer neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        sb.append(node).append(" ");
        q.offer(node);

        while (!q.isEmpty()) {
            for (int neighbor : graph.get(q.poll())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    sb.append(neighbor).append(" ");
                    q.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+4];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) graph.get(i).sort(Comparator.naturalOrder());

        Arrays.fill(visited, false);
        dfs(v);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(v);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}