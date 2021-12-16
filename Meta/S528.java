package Meta;

class S528 {

    private int[] prefixSum;
    
    public S528(int[] w) {
        
        // PrefixSum！
        //    1, 2, 3, 2, 1
        // 0, 1, 3, 6, 8, 9
        prefixSum = new int[w.length + 1];
        prefixSum[0] = 0;
        
        for (int i = 1; i < w.length + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i - 1];            
        }
        
    }
    
    public int pickIndex() {
        
        // Math.random 更快
        int randInt = (int)(Math.random() * prefixSum[prefixSum.length - 1]);
        
        for (int i = 1; i < prefixSum.length; i++) {
            if (randInt < prefixSum[i]) {
                return i - 1;
            }
        }
        
        return -1;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */