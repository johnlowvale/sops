/*
 * String Operations Demo
 * DSA Assignment 2
 * @file    Algorithm class file
 * @version 1.0
 * @author  Dat Dinhquoc
 */
package datdq.sops;

/**
 * Algorithm class
 * @author johnlowvale
 */
public class Algos {

    /**
     * Concatenate strings
     * @param strs
     * @return
     */
    public static String concatStrs(String[] strs) {
        String result = "";
        
        for (int index=0; index<strs.length; index++)
            result += strs[index];
        
        return result;
    }
    
    /**
     * Find first character
     * @param str
     * @param character
     * @return
     */
    public static int findFirstCharacter(String str,char character) {
        for (int index=0; index<str.length(); index++)
            if (str.charAt(index)==character)
                return index;
        
        return -1;
    }
    
    /**
     * Convert a string to lowercase
     * @param str
     * @return
     */
    public static String toLowercase(String str) {
        char charA = "A".charAt(0);
        char charZ = "Z".charAt(0);
        
        //make result
        String result = "";
        
        for (int index=0; index<str.length(); index++) {
            char ch = str.charAt(index);
            
            if (ch<charA || ch>charZ) {
                result += String.valueOf(ch);
                continue;
            }
            
            result += String.valueOf((char)(ch+97-65)); //'a'==97, 'A'==65
        }
        
        return result;
    }
    
    /**
     * Get a substring
     * @param str
     * @param left
     * @param right
     * @return
     */
    public static String substring(String str,int left,int right) {
        String result = "";
        int    index  = left;
        
        while (index<right && index<str.length()) {
            result += str.charAt(index);
            index++;
        }
        
        return result;
    }//substring
    
    /**
     * Trim a string on both sides
     * @param str
     * @return
     */
    public static String trimStr(String str) {
        if (str.length()==0)
            return str;
      
        //initial indices
        int left  = 0;
        int right = str.length()-1;
        
        //increase left index
        while (left<str.length() && (str.charAt(left)==(char)32 || str.charAt(left)==(char)10))
            left++;
        
        //decrease right index
        while (right>left && (str.charAt(right)==(char)32 || str.charAt(right)==(char)10))
            right--;
        
        return substring(str,left,right+1);
    }
}

//end of file