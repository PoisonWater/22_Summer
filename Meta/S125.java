package Meta;

public class S125 {

    // R2 Character.isLetterOrDigit()
    // Character.toLowerCase()
    // 别去掉空格标点再操作， 直接bitwise操作更快

    // Revisit - Character.isLetterOrDigit()

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            
            // 注意Character内置函数用法，很多，要看doc！
            // https://www.runoob.com/manual/jdk11api/java.base/java/lang/Character.html
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
            
        }
        
        return true;
    }

}
