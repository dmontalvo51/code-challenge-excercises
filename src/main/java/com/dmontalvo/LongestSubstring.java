package com.dmontalvo;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

/**
   Given a string s, find the length of the longest substring without duplicate characters.


 */

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;

        int longest=1;
        int subsSize=2;
        int start=0;
        int end=start+subsSize;

        while(subsSize<=s.length()){
            int newLongest=longest;
            while(end<=s.length()){
                if(!hasDuplicatesChars(s.substring(start,end))){
                    newLongest=subsSize;
                    break;
                }
                else{
                    start++;
                    end++;
                }
            }
            if(newLongest>longest)
                longest=newLongest;
            else{
                return longest;
            }
            subsSize++;
            start=0;
            end=start+subsSize;
        }

        return longest;
    }

    public boolean hasDuplicatesChars(String s){
        //return s.chars().distinct().count()!=s.length();
        for(char c:s.toCharArray()){
           if(s.replace(""+c, "").length()<s.length()-1)
            return true;
        }
        return false;
    }
}