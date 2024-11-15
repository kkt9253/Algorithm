import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] adj; // 지도 배열
    static int[][] fire; // 불 도착 시간
    static boolean[][] visited; // 지훈이 방문 여부
    static int r, c;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Queue<Point> qfire = new LinkedList<>();
    static Point start;

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] dimensions = br.readLine().split(" ");
        r = Integer.parseInt(dimensions[0]);
        c = Integer.parseInt(dimensions[1]);

        adj = new int[r][c];
        fire = new int[r][c];
        visited = new boolean[r][c];

        for (int[] row : fire) Arrays.fill(row, INF);

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char cell = line.charAt(j);
                if (cell == '.') {
                    adj[i][j] = 0; // 빈 공간
                } else if (cell == 'J') {
                    adj[i][j] = 0;
                    start = new Point(i, j);
                } else if (cell == 'F') {
                    adj[i][j] = -1; // 불
                    fire[i][j] = 0; // 불의 시작점
                    qfire.offer(new Point(i, j));
                } else {
                    adj[i][j] = -1; // 벽
                }
            }
        }

        // 불 BFS 실행
        bfsFire();

        // 지훈이 BFS 실행
        int result = bfsJihoon();
        if (result == -1) {
            bw.write("IMPOSSIBLE\n");
        } else {
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfsFire() {
        while (!qfire.isEmpty()) {
            Point p = qfire.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue; // 범위 초과
                if (adj[ny][nx] == -1 || fire[ny][nx] <= fire[p.y][p.x] + 1) continue; // 벽이거나 이미 방문한 경우
                fire[ny][nx] = fire[p.y][p.x] + 1; // 불의 도착 시간 갱신
                qfire.offer(new Point(ny, nx));
            }
        }
    }

    static int bfsJihoon() {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.y][start.x] = true;

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int s = 0; s < size; s++) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p.y + dy[i];
                    int nx = p.x + dx[i];

                    // 경계에 도달한 경우
                    if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                        return time;
                    }

                    // 방문 조건 체크
                    if (adj[ny][nx] == -1 || visited[ny][nx] || fire[ny][nx] <= time) continue;

                    visited[ny][nx] = true;
                    q.offer(new Point(ny, nx));
                }
            }
        }

        return -1; // 탈출 불가
    }
}
