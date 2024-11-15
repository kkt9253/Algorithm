import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] adj;
    static int[][] fire;
    static boolean[][] visited;

    static Queue<Point> qfire = new LinkedList<>();
    static Point start;
    static int r, c;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);

        adj = new int[r][c];
        fire = new int[r][c];
        visited = new boolean[r][c];

        for (int[] row : fire) Arrays.fill(row, INF);

        for (int i = 0; i < r; i++) {
            String ss = br.readLine();
            for (int j = 0; j < c; j++) {
                if (ss.charAt(j) == '.') {
                    adj[i][j] = 0;
                } else if (ss.charAt(j) == 'J') {
                    adj[i][j] = 0;
                    start = new Point(i, j);
                } else if (ss.charAt(j) == 'F') {
                    qfire.offer(new Point(i, j));
                    fire[i][j] = 0;
                } else if (ss.charAt(j) == '#') {
                    adj[i][j] = -1;
                }

                // 경계에 지훈이 시작 위치가 있는 경우 즉시 탈출
                if ((i == 0 || i == r - 1 || j == 0 || j == c - 1)) {
                    if (ss.charAt(j) == 'J') {
                        bw.write("1\n");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        // 불 BFS
        bfsFire();

        // 지훈이 BFS
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            int sy = point.y;
            int sx = point.x;

            for (int i = 0; i < 4; i++) {
                int ny = sy + dy[i];
                int nx = sx + dx[i];

                // 경계에 도달한 경우
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    bw.write((adj[sy][sx] + 1) + "\n");
                    bw.flush();
                    return;
                }

                // 방문 조건 확인
                if (adj[ny][nx] == -1 || visited[ny][nx] || fire[ny][nx] <= adj[sy][sx] + 1) continue;

                visited[ny][nx] = true;
                adj[ny][nx] = adj[sy][sx] + 1;
                q.offer(new Point(ny, nx));
            }
        }

        // 탈출 불가능한 경우
        bw.write("IMPOSSIBLE\n");
        bw.flush();
    }

    static void bfsFire() {
        while (!qfire.isEmpty()) {
            Point point = qfire.poll();
            int sy = point.y;
            int sx = point.x;

            for (int i = 0; i < 4; i++) {
                int ny = sy + dy[i];
                int nx = sx + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if (adj[ny][nx] == -1 || fire[ny][nx] != INF) continue;
                fire[ny][nx] = fire[sy][sx] + 1;
                qfire.offer(new Point(ny, nx));
            }
        }
    }
}
