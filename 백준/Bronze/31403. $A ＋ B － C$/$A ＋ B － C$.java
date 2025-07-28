import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        bw.write(a+b-c + "\n");
        bw.write(Integer.parseInt(String.valueOf(a)+String.valueOf(b)) - c + "\n");

        bw.flush();
        bw.close();
    }
}