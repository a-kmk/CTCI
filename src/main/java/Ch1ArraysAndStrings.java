import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ch1ArraysAndStrings {
    public static void main(String[] args) {
        System.out.println(PalindromePermutation("aaaabbbbcc"));
    }

    /**
     * Regular string append function, takes O(n^2) time new string copy is created on each concat
     *
     * @param words
     * @return
     */
    String joinWords(String[] words) {
        String sentence = "";
        for (String w : words) {
            sentence = sentence + w;
        }
        return sentence;
    }

    /**
     * Stringbuilder is more efficient, creates resizable array of strings and copies only when necessary
     *
     * @param words
     * @return
     */
    String joinWordsSB(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String w : words) {
            sentence.append(w);
        }
        return sentence.toString();
    }

    /**
     * 1.1 Checks if string has unique character values with the help of an array O(n^2)
     *
     * @param aString
     * @return boolean
     */
    public boolean isUnique(String aString) {
        char charArray[] = new char[aString.length()];

        if (aString.isEmpty()) return false;

        else {
            charArray[0] = aString.charAt(0);

            for (int i = 1; i < aString.length(); i++) {
                for (int j = 0; j < charArray.length; j++) {
                    if (aString.charAt(i) == charArray[j]) return
                            false;
                }
            }
            return true;
        }
    }

    /**
     * 1.1 Checks if string s has unique character values with no additional data structure O(n)
     *
     * @param s
     * @return boolean
     */
    public boolean isUniqueNoDS(String s) {

        if (s.isEmpty()) return false;
        else {
            for (int i = 1; i < s.length(); i++) {
                if (s.indexOf(i) != s.lastIndexOf(i)) return false;
            }

            return true;
        }
    }

    /**
     * 1.2 checks if a string s is a permutation of string t by first sorting then
     * checking for equality
     *
     * @param s
     * @param t
     * @return boolean, true if a permutation, false if not
     */
    public boolean checkPermutation(String s, String t) {
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

    /**
     * 1.3 change spaces into %20 to make the string URL safe
     *
     * @param str
     * @return
     */
    public String urlIfy(String str) {
        str = str.replace(" ", "%20");
        return str;
    }

    /**
     * 1.4 Write a function to check if a given string is a permutation of a palindrome, and if so
     * return the different possibilities
     *
     * @param s
     * @return
     */
    public static String PalindromePermutation(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        //handle empty and 1 char
        if (s.isEmpty())
            return "Empty string, no permutation possible";
        if (s.length() == 1)
            return s;

        //store in hashmap ordered by character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int val = map.get(c);
                val++;
                map.put(c, val);
            } else {
                map.put(c, 1);
            }
        }

        //if even check if all values are 2
        if (s.length() % 2 == 0) {
            boolean palindromePossible = true;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (!(((int) pair.getValue()) % 2 == 0)) {
                    palindromePossible = false;
                }
            }

            if (palindromePossible) {
                StringBuilder toPermute = new StringBuilder();
                it = map.entrySet().iterator();

                // get the string to be mirrored
                while (it.hasNext()) {

                    Map.Entry pair = (Map.Entry) it.next();
                    int occurences = (int) pair.getValue();

                    // returns right number of recurring characters
                    for (int i = 0; i < occurences; i += 2) {
                        toPermute.append(pair.getKey().toString());

                    }
                    //TODO: permute and mirror before returning
                    permutation("", toPermute.toString());

                }
                return toPermute.toString();

            } else {
                return "No palindromes found.";
            }
            //TODO: Handle off #



        }

        return map.toString();
    }

    private static void permutation(String prefix, String str){
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}