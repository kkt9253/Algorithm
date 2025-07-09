import java.io.*;

public class Main {

    static int a, b, v, days, h;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = in.readLine().split(" ");
        a = Integer.parseInt(arr[0]);
        b = Integer.parseInt(arr[1]);
        v = Integer.parseInt(arr[2]);

        days = (int)Math.ceil((double)(v - a) / (a - b)) + 1;

        out.write(String.valueOf(days));
        out.flush();
        out.close();
        in.close();
    }
}