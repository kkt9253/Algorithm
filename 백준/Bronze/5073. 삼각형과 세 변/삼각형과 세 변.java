import java.io.*;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {
    	
    	while(true) {
    		String[] input = br.readLine().split(" ");
    		if (input[0].equals("0")) break;
    		int a = Integer.parseInt(input[0]);
    		int b = Integer.parseInt(input[1]);
    		int c = Integer.parseInt(input[2]);
    		int max = Math.max(a, Math.max(b, c));
    		int other = a + b + c - max;
    		
    		if (max >= other) bw.write("Invalid\n");
    		else if (a == b && b == c) bw.write("Equilateral\n");
    		else if (a != b && a != c && c != b) bw.write("Scalene\n");
    		else bw.write("Isosceles\n");
    	}

    	bw.flush();
    	bw.close();
    	br.close();
    }
}