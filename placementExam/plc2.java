package placementExam;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class plc2 {

    public static void main(String args[]) {

        // Source (Line below): hackerrank.com/challenges/java-stdin-and-stdout-1

        // Scanner sc = new Scanner("3 2\n2 3\n3 4\n2 5");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();




        int twoD[][] = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                twoD[i][j] = scanner.nextInt();
            }
        }



        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();

        int key = 0;
        for (int i = 0; i < rows; i++) {

            key = scanner.nextInt();
            hash.putIfAbsent(key, new ArrayList<Integer>());

            for (int j = 0; j < columns - 1; j++) {
                hash.get(key).add(scanner.nextInt());
            }

        }



        for (int[] x : twoD) {
            for (int y : x) {
                System.out.print(y + "        ");
            }
            System.out.println();
        }



        hash.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });



        scanner.close();

    }
}
