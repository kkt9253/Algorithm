import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push")) {
                list.add(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                int siz = list.size();
                if (siz == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write( list.get(siz-1) + "\n");
                    list.remove(siz-1);
                }
            } else if (input[0].equals("top")) {
                int siz = list.size();
                if (siz == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write( list.get(siz-1) + "\n");
                }
            } else if (input[0].equals("size")) {
                bw.write(list.size() + "\n");

            } else if (input[0].equals("empty")) {
                int siz = list.size();
                if (siz == 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}