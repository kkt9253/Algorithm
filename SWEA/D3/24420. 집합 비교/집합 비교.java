import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int t;
    
	public static void main(String args[]) throws Exception, IOException
	{
		
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int a_size = Integer.parseInt(st.nextToken());
            int b_size = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                b.add(Integer.parseInt(st.nextToken()));
            }
            a.sort(Comparator.naturalOrder());
            b.sort(Comparator.naturalOrder());

            if (a_size == b_size) {
                    if (a.containsAll(b)) {
                        sb.append("=").append("\n");
                    } else {
                        sb.append("?").append("\n");
                    }
            } else if (a_size > b_size) {
                if (a.containsAll(b)) {
                    sb.append(">").append("\n");
                } else {
                    sb.append("?").append("\n");
                }
            } else {
                if (b.containsAll(a)) {
                    sb.append("<").append("\n");
                } else {
                    sb.append("?").append("\n");
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
	}
}