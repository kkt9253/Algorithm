import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] fruit;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        fruit = new int[Integer.parseInt(stk.nextToken())];
        int snake = Integer.parseInt(stk.nextToken());

        StringTokenizer fL = new StringTokenizer(br.readLine());
        for (int i = 0; i < fruit.length; i++) {
            fruit[i] = Integer.parseInt(fL.nextToken());
        }

        for (int i = 0; i < fruit.length; i++) {
            if (snake >= fruit[i]) {
                fruit[i] = 10001;
                snake++;
                i = -1;
            }
        }

        bw.write(String.valueOf(snake));

        br.close();
        bw.flush();
        bw.close();
    }

}