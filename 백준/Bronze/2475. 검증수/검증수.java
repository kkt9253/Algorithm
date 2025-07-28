import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        bw.write((
                Integer.parseInt(input[0])*Integer.parseInt(input[0]) +
                Integer.parseInt(input[1]) * Integer.parseInt(input[1]) +
                Integer.parseInt(input[2]) * Integer.parseInt(input[2]) +
                Integer.parseInt(input[3]) * Integer.parseInt(input[3]) +
                Integer.parseInt(input[4]) * Integer.parseInt(input[4])
                ) % 10 + "\n");
        bw.flush();
        bw.close();
    }
}