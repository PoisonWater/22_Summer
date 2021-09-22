class S125 {
    public static boolean isPalindrome(String s) {
        String out = s.replaceAll("\\s*","").replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] comp = out.toCharArray();
        System.out.println(out);

        for (int i = 0; i < comp.length/2; i++) {
            if (comp[i] != comp[comp.length-1-i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String n = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        System.out.println(isPalindrome(n));
    }
}