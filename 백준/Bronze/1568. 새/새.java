import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int bird = Integer.parseInt(br.readLine());
        int song = 0, count = 0;

        while (bird != 0) {
            song++;
            if (bird < song) song = 1;
            bird -= song;
            count++;
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }

}