import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int val = (int) Math.pow(Math.pow(2, n) + 1, 2);
        bw.write(String.valueOf(val));

        bw.flush();
        bw.close();
        br.close();
    }
}