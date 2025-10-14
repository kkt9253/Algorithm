import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> sort_arr = new ArrayList<>(arr);
        sort_arr.sort(Comparator.naturalOrder());

        int cnt = 0;
        int prev = -1_000_000_001;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : sort_arr) {
            if (i != prev) {
                map.put(i, cnt++);
                prev = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : arr) {
            sb.append(map.get(i)).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}