import java.io.*;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr = new int[9][9];
    static ArrayList<Node> find_nodes = new ArrayList<>();

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
        int getY() {
            return this.y;
        }
        int getX() {
            return this.x;
        }
    }

    static boolean solve(int depth) {

        if (depth == find_nodes.size()) return true;

        Node curr_node = find_nodes.get(depth);
        int y = curr_node.getY();
        int x = curr_node.getX();

        for (int i = 1; i <= 9; i++) {
            if (isValid(y, x, i)) {
                arr[y][x] = i;
                if (solve(depth + 1)) return true;
                arr[y][x] = 0;
            }
        }

        return false;
    }

    static boolean isValid(int y, int x, int num) {

        // 가로
        for (int i = 0; i < 9; i++) {
            if (arr[y][i] == num) return false;
        }

        // 세로
        for (int i = 0; i < 9; i++) {
            if (arr[i][x] == num) return false;
        }

        // 정사각형
        int start_y = y / 3 * 3;
        int start_x = x / 3 * 3;
        for (int i = start_y; i < start_y + 3; i++) {
            for (int j = start_x; j < start_x + 3; j++) {
                if (arr[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if (arr[i][j] == 0) find_nodes.add(new Node(i, j));
            }
        }

        solve(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}