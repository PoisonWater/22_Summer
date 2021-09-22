package placementExam;
class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
    // Write your code here
        String out = String.valueOf(n);
        if (n % 15 == 0) {
            out = "FizzBuzz";
        } else if (n % 3 == 0) {
            out = "Fizz";
        } else if (n % 5 == 0) {
            out = "Buzz";
        }

        System.out.println(out);
    }

}
