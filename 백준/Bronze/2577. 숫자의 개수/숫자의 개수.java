import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {

    	int a = Integer.parseInt(br.readLine());
    	int b = Integer.parseInt(br.readLine());
    	int c = Integer.parseInt(br.readLine());
    	int[] val = new int[10];
    	
    	String s = String.valueOf(a*b*c);
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = 0; j < 10; j++) {
    			if (s.charAt(i) - '0' == j) {
    				val[j]++;
    				break;
    			}
    		}
    	}

    	for (int i = 0; i <= 9; i++) bw.write(val[i] + "\n");
    	
    	bw.flush();
    	bw.close();
    	
    }
}