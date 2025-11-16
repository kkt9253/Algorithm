import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static class Room {
        List<Player> players;
        int siz;
        int standardLevel;

        public Room(Player player) {
            this.players = new ArrayList<>();
            this.players.add(player);
            this.siz = 1;
            this.standardLevel = player.getLevel();
        }

        public void addPlayer(Player player) {
            this.players.add(player);
            this.siz++;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public int getSiz() {
            return siz;
        }

        public int getStandardLevel() {
            return standardLevel;
        }
    }

    static class Player implements Comparable<Player>{
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public String getName() {
            return name;
        }

        public String printPlayer() {
            return this.getLevel() + " " + this.getName();
        }

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int p, m;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());

            boolean flag = true;

            for (Room room : rooms) {
                if (room.getSiz() < m && room.getStandardLevel() - 10 <= player.getLevel() && player.getLevel() <= room.getStandardLevel() + 10) {
                    room.addPlayer(player);
                    flag = false;
                    break;
                }
            }
            if (flag) rooms.add(new Room(player));
        }

        for (Room room : rooms) {
            if (room.getSiz() < m) {
                sb.append("Waiting!").append("\n");
            } else {
                sb.append("Started!").append("\n");
            }

            room.getPlayers().stream()
                    .sorted()
                    .forEach(p -> sb.append(p.printPlayer()).append("\n"));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
