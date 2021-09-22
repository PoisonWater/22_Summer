class S344 {
    public void reverseString(char[] s) {

        char rpl;

        for (int i = 0; i < s.length/2; i++) {
            rpl = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = rpl;
        }

    }
}
