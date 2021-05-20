import java.util.Arrays;

public class Ch1ArraysAndStrings {
    public static void main(String[] args){

    }

    /**
     * 1.1 Checks if string has unique character values with the help of an array O(n^2)
     * @param aString
     * @return boolean
     */
    public boolean isUnique(String aString){
       char charArray[] = new char[aString.length()];

       if (aString.isEmpty()) return false;

       else {
           charArray[0] = aString.charAt(0);

           for(int i=1; i<aString.length(); i++){
               for (int j=0; j<charArray.length; j++){
                   if (aString.charAt(i) == charArray[j]) return
                           false;
               }
           }
           return true;

           // Another way, split by index, if the resulting array is longer than 2 elements, it's not unique
       }
    }

    /**
     * 1.1 Checks if string s has unique character values with no additional data structure O(n)
     * @param s
     * @return boolean
     */
    public boolean isUniqueNoDS(String s){

        if (s.isEmpty()) return false;
        else {
            for (int i = 1; i < s.length(); i++) {
                if (s.indexOf(i) != s.lastIndexOf(i)) return false;
            }

            return true;
        }
    }

    /**
     * 1.2 checks if a string s is a permutation of string t
     * @param s
     * @param t
     * @return boolean, true if a permutation, false if not
     */
    public boolean checkPermutation(String s, String t){
        if (s.length() != t.length())
            return false;
        else {
            char sArray[] = s.toCharArray();
            Arrays.sort(sArray);
            char tArray[] = t.toCharArray();
            Arrays.sort(tArray);

            return (new String(sArray).equals(new String(tArray)));
        }
    }




}
