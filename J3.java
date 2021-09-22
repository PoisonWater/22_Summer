class J3 {
    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i, '0');
                sb.insert(i, '2');
                sb.insert(i, '%');
            }
        }

        return sb.toString();
    }
}