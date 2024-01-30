package com.array;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {


    public static void main(String[] args) {
        String s1 = "car";
        String s2 = "rat";
        System.out.println(isAnagram(s1, s2));
    }


    //Working raw version
   /* public static boolean isAnagram(String s, String t) {
        //mom, moo
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> firstStringMap = new HashMap<>();
        HashMap<Character, Integer> secondStringMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(firstStringMap.containsKey(s.charAt(i))){
                int currentValue = firstStringMap.getOrDefault(s.charAt(i), 1);
                firstStringMap.put(s.charAt(i),currentValue+1);
            }else{
                firstStringMap.put(s.charAt(i),1);
            }
            if(secondStringMap.containsKey(t.charAt(i))){
                int currentValue = secondStringMap.getOrDefault(t.charAt(i), 1);
                secondStringMap.put(t.charAt(i),currentValue+1);
            }else{
                secondStringMap.put(t.charAt(i),1);
            }
        }

        //iterate both maps and compare key and value

        boolean same = true;
        for(Map.Entry<Character, Integer> entry: secondStringMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());

            if(firstStringMap.containsKey(entry.getKey())){
                System.out.println("firstStringMap contains "+ entry.getKey()+" value: "+entry.getValue() );
                if(entry.getValue().intValue() !=  firstStringMap.get(entry.getKey()).intValue()){
                    same = false;
                }
            }else{
                same = false;
            }

        }

        return same;

    }*/

    public static boolean isAnagram(String s, String t) {
        //mom, moo
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> firstStringMap = new HashMap<>();
        HashMap<Character, Integer> secondStringMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(firstStringMap.containsKey(s.charAt(i))){
                int currentValue = firstStringMap.getOrDefault(s.charAt(i), 1);
                firstStringMap.put(s.charAt(i),currentValue+1);
            }else{
                firstStringMap.put(s.charAt(i),1);
            }
            if(secondStringMap.containsKey(t.charAt(i))){
                int currentValue = secondStringMap.getOrDefault(t.charAt(i), 1);
                secondStringMap.put(t.charAt(i),currentValue+1);
            }else{
                secondStringMap.put(t.charAt(i),1);
            }
        }

        //iterate both maps and compare key and value

        boolean same = true;
        for(Map.Entry<Character, Integer> entry: secondStringMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());

            if(firstStringMap.containsKey(entry.getKey())){
                System.out.println("firstStringMap contains "+ entry.getKey()+" value: "+entry.getValue() );
                if(entry.getValue().intValue() !=  firstStringMap.get(entry.getKey()).intValue()){
                    same = false;
                }
            }else{
                same = false;
            }

        }

        return same;

    }
}
