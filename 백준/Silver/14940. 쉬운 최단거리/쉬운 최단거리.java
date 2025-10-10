import java.io.*;
import java.util.*;

class Main {

    static int n, m, r_y, r_x;
    static int[][] graph = new int[1004][1004];
    static int[][] visited = new int[1004][1004];

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int sy, int sx) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sy, sx});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int next_y = cur[0] + dy[k];
                int next_x = cur[1] + dx[k];
                if (0 <= next_y && next_y < n && 0 <= next_x && next_x < m && visited[next_y][next_x] == -1 && graph[next_y][next_x] == 1) {
                    visited[next_y][next_x] = visited[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{next_y, next_x});
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

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    r_y = i;
                    r_x = j;
                } else if (graph[i][j] == 1) {
                    visited[i][j] = -1;
                }
            }
        }

        bfs(r_y, r_x);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(visited[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}