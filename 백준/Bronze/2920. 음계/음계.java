import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String a = "1 2 3 4 5 6 7 8";
        String b = "8 7 6 5 4 3 2 1";

        String s = br.readLine();

        if (a.equals(s)) bw.write("ascending");
        else if (b.equals(s)) bw.write("descending");
        else bw.write("mixed");

        bw.flush();
        bw.close();
    }
}