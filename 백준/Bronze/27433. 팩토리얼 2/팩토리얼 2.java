import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static long solve(long n) {
		if (n == 0 || n == 1) return 1;
		return n * solve(n - 1);
	}
	
    public static void main(String[] args) throws IOException {
    	long n = Long.parseLong(br.readLine());
    	bw.write(solve(n) + "\n");
    	bw.flush();
    	bw.close();
    }
}