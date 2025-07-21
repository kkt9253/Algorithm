import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {

    	int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer> arr = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		arr.add(Integer.parseInt(br.readLine()));
    	}
    	arr.sort(Comparator.naturalOrder());
    	
    	for (Integer a : arr) {
    		bw.write(a + "\n");
    	}
    	
    	bw.flush();
    	bw.close();
    	
    }
}