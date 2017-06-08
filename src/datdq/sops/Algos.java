/*
 * String Operations Demo
 * DSA Assignment 2
 * @file    Algorithm class file
 * @version 1.0
 * @author  Dat Dinhquoc
 */
package datdq.sops;

//java core classes
import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * Get character at reverse index in a string, last character has index of 0
     * @param str
     * @param index
     * @return
     */
    public static char reverseCharAt(String str,int index) {
        try {
            int lastIndex = str.length()-1;
            return str.charAt(lastIndex-index);
        }
        catch (Exception exception) {
            return (char)0;
        }
    }
    
    /**
     * Sort a list of string at certain reverse index (mainly for number, not string)
     * @param strs
     * @param index
     * @return
     */
    public static List<String> sortAtDigit(List<String> strs,int digitIndex) {
        List<String> newStrs = new ArrayList<String>();
        
        //48='0', 57='9'
        for (char ch=(char)48; ch<=(char)57; ch++)
            for (int index=0; index<strs.size(); index++)
                if (reverseCharAt(strs.get(index),digitIndex)==ch)
                    newStrs.add(strs.get(index));
        
        return newStrs;
    }
    
    /**
     * Radixsort a string list using most-significant-digit (MSD)
     * @param strs
     * @return
     */
    public static List<String> radixSort(List<String> strs) {
      
        //find max length
        int maxLen = -1;
        
        for (int index=0; index<strs.size(); index++) 
            if (strs.get(index).length() > maxLen)
                maxLen = strs.get(index).length();
        
        //sort from most significant digit
        for (int index=maxLen-1; index>=0; index--)
            strs = sortAtDigit(strs,index); //index counted from MSD
        
        return strs;
    }
}

//end of file