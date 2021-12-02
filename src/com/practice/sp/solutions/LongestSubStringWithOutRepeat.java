package com.practice.sp.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestSubStringWithOutRepeat {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> ref = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        int result = 0;

        for(char c: s.toCharArray()) {
            while(ref.contains(c)) {
                char temp = queue.remove();
                ref.remove(temp);
            }

            ref.add(c);
            queue.add(c);
            result = java.lang.Math.max(result, queue.size());
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkey";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
