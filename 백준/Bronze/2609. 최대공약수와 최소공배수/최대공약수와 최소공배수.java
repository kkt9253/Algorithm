import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;


class Main {

    static int solve(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        int c = solve(a, b);
        System.out.println(c);
        System.out.println(a*b/c);
    }
}