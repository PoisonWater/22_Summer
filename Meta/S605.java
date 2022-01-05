package Meta;

public class S605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ptr = 0, ctr = 1, total = 0;
        
        while (ptr < flowerbed.length) {
            if (flowerbed[ptr] == 0) {
                ctr++;
            } else {
                total += (ctr - 1) / 2;
                ctr = 0;
            }
            ptr++;
        }
        
        total += ctr / 2;
        
        return total >= n;
    }
}
