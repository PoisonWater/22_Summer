package placementExam;
import java.util.Scanner;

public class plc1 {
    
    public static void main(String[] args) {
        // Source (Line below): hackerrank.com/challenges/java-stdin-and-stdout-1
        Scanner scanner = new Scanner(System.in);

        String myString = scanner.next();
        int myInt = scanner.nextInt();
        scanner.close();

        System.out.println("myString is: " + myString);
        System.out.println("myInt is: " + myInt);

    }
}

