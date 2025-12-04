import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        SortedSet<String> ss = new TreeSet<>(String::compareTo);
        HashMap<String, Integer> map = new HashMap<>();
        int treeCnt = 0;
        while (true) {
            String line = br.readLine();
            if (line == null || line.isBlank()) {
                break;
            }

            treeCnt++;
            if (ss.contains(line)) {
                map.replace(line, map.get(line) + 1);
            } else {
                ss.add(line);
                map.put(line, 1);
            }
        }

        double treeV = (double) 100 / treeCnt;

        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s).append(" ").append(String.format("%.4f", treeV * map.get(s))).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
