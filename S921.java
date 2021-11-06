class S921 {
    public int minAddToMakeValid(String s) {
        int stackCounter = 0;
        int moves = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stackCounter++;
            } else if (c == ')') {
                if (stackCounter == 0) {
                    moves++;
                } else {
                    stackCounter--;
                }
            }
        }
        return moves + stackCounter;
    }
}