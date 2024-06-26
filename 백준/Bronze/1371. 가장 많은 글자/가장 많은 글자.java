import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        int[] value = new int[26];

        while ((input = br.readLine()) != null) {
            sb.append(input);
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isAlphabetic(c)) value[c - 'a']++;
        }

        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (value[i] > max) max = value[i];
        }

        for (int i = 0; i < 26; i++) {
            if (value[i] == max) bw.write('a' + i);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}