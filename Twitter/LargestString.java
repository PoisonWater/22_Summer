package Twitter;
// skipped
// https://www.geeksforgeeks.org/largest-lexicographical-string-with-at-most-k-consecutive-elements/

// Java solution for above approach
import java.util.*;

class GFG {

    // Function to find largest string
    static String newString(String originalLabel, int limit) {
        int n = originalLabel.length();
        // Stores the frequency of characters
        int[] charset = new int[26]; // IMPORTANT

        // Traverse the string
        for (int i = 0; i < n; i++) {
            charset[originalLabel.charAt(i) - 'a']++;
        }

        // Stores the resultant string
        StringBuilder newString = new StringBuilder(n);

        for (int i = 25; i >= 0; i--) {

            int count = 0;

            // Append larger character
            while (charset[i] > 0) {

                newString.append((char) (i + 'a'));

                // Decrease count in charset
                charset[i]--;

                // Increase count
                count++;

                // Check if count reached to charLimit
                if (charset[i] > 0 && count == limit) {

                    // Find nearest lower char
                    Character next = nextAvailableChar(charset, i);

                    // If no character can be appended
                    if (next == null)
                        return newString.toString();

                    // Append nearest lower character
                    newString.append(next);

                    // Reset count for next calculation
                    count = 0;
                }
            }
        }

        // Return new largest string
        return newString.toString();
    }

    // Function to return nearest lower character
    static Character nextAvailableChar(int[] charset, int start) {
        // Traverse charset from start-1
        for (int i = start - 1; i >= 0; i--) {

            if (charset[i] > 0) {

                charset[i]--;
                return (char) (i + 'a');
            }
        }
        // If no character can be appended
        return null;
    }

    // Driver Code
    public static void main(String[] args) {
        String S = "ccbbb";
        int K = 2;
        System.out.println(newString(S, K));
    }
}