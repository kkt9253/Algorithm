import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double[] value = new double[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int number = Integer.parseInt(st.nextToken());
            double distance = Double.parseDouble(st.nextToken());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double fly = Double.parseDouble(st.nextToken());
            double time = distance / (a + b);

            value[i] = time * fly;
            bw.write(String.format("%d %.6f\n", number, value[i]));
        }
        br.close();
        bw.flush();
        bw.close();
    }
}