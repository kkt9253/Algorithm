import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());
        for (Integer i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}