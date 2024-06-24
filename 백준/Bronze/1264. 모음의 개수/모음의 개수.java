import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        String input = "";

        while(!input.equals("#")) {
            input = scan.nextLine();

            if (!input.equals("#")) {
                inputList.add(input);
                
            }
        }
        scan.close();

        for (String n : inputList) {
            int count = 0;
            for (int i = 0; i < n.length(); i++) {
                char j = Character.toLowerCase(n.charAt(i));
                if (j == 'a' || j == 'e' || 
                    j == 'i' || j == 'o' || j == 'u') {
                    count += 1;
                }
            }
            value.add(count);
        }

        for (int n : value) {
            System.out.println(n);
        }
    }
}