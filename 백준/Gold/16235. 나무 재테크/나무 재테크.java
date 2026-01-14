import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, k;
    static int[][] yangbun = new int[14][14];
    static int[][] robot = new int[14][14];
    static ArrayList<Integer>[][] trees = new ArrayList[14][14];
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                trees[i][j] = new ArrayList<>();
                yangbun[i][j] = 5;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                robot[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            trees[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]
                    .add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < k; i++) {
            springSummer();
            fall();
            winter();
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret += trees[i][j].size();
            }
        }

        bw.write(ret + "\n");

        bw.close();
        br.close();
    }

    static void springSummer() {
        // 전체 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // trees 정렬
                Collections.sort(trees[i][j]);

                // 어린 나무부터 순회하면서 봄/여름 처리
                outer:
                for (int l = 0; l < trees[i][j].size(); l++) {
                    // 양분 못먹이면
                    if (yangbun[i][j] < trees[i][j].get(l)) {
                        // 현재 나무부터 마지막까지
                        for (int o = l; o < trees[i][j].size(); o++) {
                            // 죽을 나무에 대해 양분 +
                            yangbun[i][j] += trees[i][j].get(o)/2;
                        }
                        // 죽은 나무 모두 삭제
                        int siz = trees[i][j].size();
                        for (int o = l; o < siz; o++) {
                            trees[i][j].remove(trees[i][j].size()-1);
                        }
                        break outer;
                    } else {
                        // 봄 - 양분 먹이고, 나무 나이 +1
                        int age = trees[i][j].get(l);
                        yangbun[i][j] -= age;
                        trees[i][j].set(l, age+1);
                    }
                }
            }
        }
    }

    static void fall() {
        // 전체 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 칸의 나무 순회하면서
                for (int l = 0; l < trees[i][j].size(); l++) {
                    // 5의 배수면
                    if (trees[i][j].get(l) % 5 == 0) {
                        // 인접 칸에 나이가 1인 나무 추가
                        for (int o = 0; o < 8; o++) {
                            int nextX = i + dx[o];
                            int nextY = j + dy[o];
                            if (nextX < 0 || n <= nextX || nextY < 0 || n <= nextY) continue;
                            trees[nextX][nextY].add(1);
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        // 전체 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 로봇이 양분 주기
                yangbun[i][j] += robot[i][j];
            }
        }
    }
}
