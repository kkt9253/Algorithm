import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int solve(int n) {
		
		if (n == 1) return 0;
		for (int i = 1; i < n; i++) {
			int sum = i;

			// 각 자리수 합
			int temp = i;
			for (int j = String.valueOf(i).length()-1; j >= 0; j--) {
				sum += temp / (int)Math.pow(10, j);
				temp = temp % (int)Math.pow(10, j);
			}
			if (sum == n) return i;
		}
		
		return 0;
	}
	
    public static void main(String[] args) throws IOException {

    	int n = Integer.parseInt(br.readLine());
    	bw.write(solve(n) + "\n");
    	
    	bw.flush();
    	bw.close();
    	
    }
}