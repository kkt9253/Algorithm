import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int fatigue, task, a, b, c, m;

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 24; i++) {
            work();
            if (fatigue > m) {
                rollback();
                rest();
            }
        }

        bw.write(task + "\n");
        bw.close();
    }

    static void work() {
        fatigue += a;
        task += b;
    }

    static void rest() {
        fatigue = Math.max(0, fatigue - c);
    }

    static void rollback() {
        fatigue -= a;
        task -= b;
    }
}
