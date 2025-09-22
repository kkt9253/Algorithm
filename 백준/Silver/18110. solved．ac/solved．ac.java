import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            arr.add(a);
        }

        arr.sort(Comparator.naturalOrder());

        int a = (int) Math.round(n * 0.15);

        int sum = 0;
        for (int i = a; i < n-a; i++) {
            sum += arr.get(i);
        }

        bw.write(String.valueOf(Math.round((float) sum/(n-a-a))));

        bw.flush();
        bw.close();
        br.close();
    }
}