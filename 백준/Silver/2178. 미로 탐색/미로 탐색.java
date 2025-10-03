import java.io.*;
import java.util.*;

class Main {

    static int[][] graph = new int[104][104];
    static int[][] visited = new int[104][104];
    static int n, m;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int moveX = cur[0] + dx[k];
                int moveY = cur[1] + dy[k];
                if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < m && visited[moveX][moveY] == 0 && graph[moveX][moveY] == 1) {
                    q.offer(new int[]{moveX, moveY});
                    visited[moveX][moveY] = visited[cur[0]][cur[1]] + 1;
                    if (moveX == n-1 && moveY == m-1) return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(visited[n-1][m-1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}