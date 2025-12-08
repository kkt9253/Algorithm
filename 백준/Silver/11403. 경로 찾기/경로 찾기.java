import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[104];

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    graph.get(i).add(j); // 방향 간선 추가
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            dfs(i);

            for (int j = 0; j < n; j++) {
                if (visited[j]) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static void dfs(int start) {
        for (Integer next : graph.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
