import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        int count = 0;
        Scanner word = new Scanner(str);

        while (word.hasNext()) {
            word.next();
            count += 1;
        }

        System.out.println(count);
        word.close();
        scan.close();
    }
}