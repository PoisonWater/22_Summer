import java.util.HashSet;

class S202 {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        int res = n;

        while (!set.contains(res)) {

            // HashSet
            set.add(res);
            
            // Split the number and Calculate Result;
            int left = res; 
            res = 0;

            while (left != 0) {
                res += (left % 10) * (left % 10);
                left = left / 10;
            }

            // Judge
            if (res == 1) { return true; }

        }

        return false;

    }

    public static void main(String[] args) {
        S202 n = new S202();
        n.isHappy(19);
    }
}
