import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {

    private int age;
    private String name;
    private int joinOrder;

    Person(int age, String name, int joinOrder) {
        this.age = age;
        this.name = name;
        this.joinOrder = joinOrder;
    }
    public int getAge() {
        return age;
    }

    public int getJoinOrder() {
        return joinOrder;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {

        if (this.age != o.age) {
            return this.age - o.age;
        }

        return this.joinOrder - o.joinOrder;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Person> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            pq.offer(new Person(Integer.parseInt(stk.nextToken()), stk.nextToken(), i));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!pq.isEmpty()) {
            Person p = pq.poll();
            bw.write(p.getAge() + " " + p.getName() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}