import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] point = new int[8];
        Integer[] sortPoint = new Integer[8];

        for (int i = 0; i < 8; i++) {
            point[i] = Integer.parseInt(br.readLine());
            sortPoint[i] = point[i];
        }
        Arrays.sort(sortPoint, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += sortPoint[i];
        }
        bw.write(String.valueOf(sum) + "\n");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (point[j] == sortPoint[i]) {
                    numbers.add(j+1);
                    break;
                }
            }
        }
        Collections.sort(numbers);
        for (Integer number : numbers) {
            bw.write(String.valueOf(number) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}