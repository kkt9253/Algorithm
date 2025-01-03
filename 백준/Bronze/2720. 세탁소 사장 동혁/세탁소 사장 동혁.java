import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int _input;

    static public int solve(int ipt, int na) {
        int a = (ipt / na);
        _input = (ipt % na);
        return a;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            _input = Integer.parseInt(br.readLine());
            int a = solve(_input, 25);
            int b = solve(_input, 10);
            int c = solve(_input, 5);
            int d = solve(_input, 1);
            bw.write(a + " " + b + " " + c + " " + d + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}