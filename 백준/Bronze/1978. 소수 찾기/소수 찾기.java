import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int cnt;

    public static void main(String[] args) throws IOException {
    	
    	int n = Integer.parseInt(br.readLine());
    	String[] input = br.readLine().split(" ");
    	for (String s : input) {
    		int int_s = Integer.parseInt(s);
    		if (int_s == 1) {
    			continue;
    		}
    		boolean flag = true;
    		for (int i = 2; i <= Math.sqrt(int_s); i++) {
    			if (int_s % i == 0) {
    				flag = false;
    				break;
    			}
    		}
    		if (flag) cnt++;
    	}
    	bw.write(cnt + "\n");
    	bw.flush();
    	bw.close();
    	br.close();
    }
}