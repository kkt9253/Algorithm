import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum += list.get(i);
                continue;
            }

            list.set(i, list.get(i-1)+list.get(i));
            sum += list.get(i);
        }
        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}