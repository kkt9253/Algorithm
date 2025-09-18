import java.io.*;
import java.util.*;


class Main {
    static ArrayList<Integer> list = new ArrayList<>();

    static boolean solve(int start, int end, int a) {

        if (start > end) return false;
        int middle = start + (end - start) / 2;

        if (list.get(middle) == a) return true;
        else if (list.get(middle) < a) return solve(middle + 1, end, a);
        else return solve(start, middle - 1, a);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (solve(0, n-1, a)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}