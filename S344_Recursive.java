class S344_Recursive {

    int len = 0;

    public void reverse(char[] s, int index) {
        if (index == s.length/2) 
            return;

        char p = s[index];
        s[index] = s[len-index-1];
        s[len-index-1] = p;

        reverse(s, index+1);
    }

    public void reverseString(char[] s) {
        len = s.length;
        reverse(s, 0);
    }
}