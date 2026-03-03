package com.company.fearless;

import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = 0,left =0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            //如果当前字符已经存在，更新左指针位置
            if (map.containsKey(current)){
                left = Math.max(left,map.get(current)+1);

            }

            //更新当前字符位置
            map.put(current,right);

            //更新最大长度
            maxLength = Math.max(maxLength,right-left+1);

        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("ahfioajhida"));
    }
}
