package placementExam;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class plc00 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        // Take Input

        // Source (Line below): hackerrank.com/challenges/java-stdin-and-stdout-1
        Scanner scanner = new Scanner(System.in);
        int maxDuration = scanner.nextInt();
        int rows = scanner.nextInt();
        int columns = 3;

        int logs[][] = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                logs[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        
        // Verification

        int maxCourse = 0;
        int maxCourseDuration = -1;
        int numExceeded = 0;

        for (int i = 0; i < logs.length; i++) {
            if (logs[i][2] - logs[i][1] > maxDuration) {
                numExceeded += 1;
            }
            if (maxCourseDuration < logs[i][2] - logs[i][1]) {
                maxCourseDuration = logs[i][2] - logs[i][1];
                maxCourse = logs[i][0];
            }
        }

        // Sysout

        System.out.println(String.valueOf(numExceeded) + " " + String.valueOf(maxCourse));

    }
}