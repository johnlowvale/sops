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
}

//end of file