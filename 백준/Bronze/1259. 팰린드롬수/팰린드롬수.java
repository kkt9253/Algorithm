import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int input;

        do {
            input = scan.nextInt();
            if (input != 0) {
                list.add(input);
            }
        } while (input != 0);

        List<String> list2 = new ArrayList<>();
        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {
            String value = Integer.toString(list.get(i));
            boolean isPalindrome = true;

            for (int j = 0; j < value.length()/2; j++) {
                if (value.charAt(j) != value.charAt(value.length() - j - 1)) {
                    list2.add("no");
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome){
                list2.add("yes");
            }
        }

        for (String result : list2) {
            System.out.println(result);
        }
        scan.close();
    }
}