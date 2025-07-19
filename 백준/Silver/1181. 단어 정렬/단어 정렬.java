import java.io.*;
import java.util.ArrayList;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
    	int n = Integer.parseInt(br.readLine());
    	
    	ArrayList<String> arr = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		arr.add(br.readLine());
    	}
    	
    	arr.stream()
    		.distinct()
    		.sorted((a, b) -> 
    			{
    				if (a.length() != b.length()) {
        				return a.length() - b.length();
        			} else {
        				return a.compareTo(b);
        			}
    			})
    		.forEach(System.out::println);
    }
}