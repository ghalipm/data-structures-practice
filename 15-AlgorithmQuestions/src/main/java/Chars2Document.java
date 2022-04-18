package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chars2Document {

    public static void main(String[] args) {

        //  String chars = "!veDJaCyd vaeo perelo xw"; // 2as ('a',2) --> ('a', 1) --> ('a',0)
        //  String document = "Cydeo Java Developer!";

        String chars = "a b c c 1 2 3 4 5 6 0c ";
        String document = "ccba0c  12345           ";

        System.out.println(generateDoc3(chars, document));
    }

    //Convert chars into a hashMap
    // Loop through document,
    // if I cannot find a char from my document in the map, return false
    // If I find, I will decrease the value by 1
    // ifI I find, but the value is 0, return false;

    //---------------------------
    // Convert chars and document into separate hashMaps
    // Compare hasMap values using a loop
    // (if a key from doc exists in chars and it s value is > chars value  OR key does not exist )return false
    // return true
    //---------------------------
    // Make two array lists
    // check if source containsAll doc

    private static boolean generateDoc(String chars, String document) {

        Map<Character, Integer> charMap = stringToMap(chars);
//
//        for (char c : chars.toCharArray()) { // O(n)
//            if (c == ' ') continue;
//            if (charMap.containsKey(c)) {
//                charMap.put(c, charMap.get(c) + 1); // c already exists in the map
//            } else {
//                charMap.put(c, 1); // c is not in the map
//            }
//        }

        for (Character c : document.toCharArray()) { // O(n)
            if (c == ' ') continue;

            if (!charMap.containsKey(c)) {
                return false;

            } else if (charMap.containsKey(c) && charMap.get(c) == 0) {
                return false;
            } else {
                charMap.put(c, charMap.get(c) - 1);
            }

        }

        return true;
    }

    private static boolean generateDoc2(String chars, String document) {
        Map<Character, Integer> sourceMap = stringToMap(chars); // O(n)
        Map<Character, Integer> docMap = stringToMap(document); // O(n)

        return compareTwoMaps(docMap, sourceMap);

    }

    private static boolean compareTwoMaps(Map<Character, Integer> docMap, Map<Character, Integer> sourceMap) {

        for (Character c : docMap.keySet()) { //O(n)

            if (c == ' ') continue;

            if (!sourceMap.containsKey(c)) {
                return false;

            } else if (sourceMap.containsKey(c) && sourceMap.get(c) == 0) {
                return false;
            } else {
                sourceMap.put(c, sourceMap.get(c) - 1);
            }

        }

        return true;
    }

    private static Map<Character, Integer> stringToMap(String str) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : str.toCharArray()) { // O(n)
            if (c == ' ') continue;
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1); // c already exists in the map
            } else {
                charMap.put(c, 1); // c is not in the map
            }
        }

        return charMap;
    }

    //list method
    private static boolean generateDoc3(String source, String document) {
        // source list contains document list?
        return stringToArrayList(source).containsAll(stringToArrayList(document));
    }

    private static ArrayList<Character> stringToArrayList(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list;
    }

}