class J58 {
    public String reverseLeftWords(String s, int n) {
        return s.concat(s.substring(0, n)).substring(n, s.length()+n);
    }
}