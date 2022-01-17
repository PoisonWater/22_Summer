package Meta;

public class S605 {

    // Revisit
    public boolean canPlaceFlowersR(int[] flowerbed, int n) {
        // 0s:
        // 3 - 1; 4 - 1; 5 - 2; ...
        // (x-1)/2
        int seq0 = 1, ctr = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                seq0++;
            } else {
                ctr += (seq0 - 1) / 2;
                seq0 = 0;
            }
        }
        ctr += seq0 / 2;
        seq0 = 0;
        
        return ctr >= n;
    }

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
