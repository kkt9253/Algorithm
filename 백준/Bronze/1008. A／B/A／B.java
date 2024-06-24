import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int one = scan.nextInt();
    int two = scan.nextInt();

    double value = (double) one/two;

    System.out.println(value);
  }
}