import java.io.*;
import java.util.*;

class Main {

    static int n, r, c;

    static int solve(int depth, int sy, int sx) {
        if (depth == 0) {
            return 0;
        }

        int half_siz = (int) Math.pow(2, depth-1);
        int area = half_siz * half_siz;
        
        if (r < sy+half_siz && c < sx+half_siz) {
            return solve(depth-1, sy, sx);
        } else if (r < sy+half_siz && sx+half_siz <= c) {
            return solve(depth-1, sy, sx+half_siz) + area;
        } else if (r < sy+half_siz*2 && c < sx+half_siz) {
            return solve(depth-1, sy+half_siz, sx) + area*2;
        } else {
            return solve(depth-1, sy+half_siz, sx+half_siz) + area*3;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bw.write(solve(n, 0, 0) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}