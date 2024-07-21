package Day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // Building the HashMap
            HashMap<String, List<String>> map = new HashMap<>();

            for (String word : strs) {
                // Converting each word into a character array
                char[] ch = word.toCharArray();
                // Sorting the character array
                Arrays.sort(ch);

                // Converting the sorted character array into string
                String sortedWord = new String(ch);

                if (!map.containsKey(sortedWord)) {
                    map.put(sortedWord, new ArrayList<>());
                }
                map.get(sortedWord).add(word);
            }
            // This line creates a new ArrayList containing all the values (lists of
            // original words) from the HashMap map and returns it. Each element of this
            // ArrayList represents a group of anagrams.
            return new ArrayList<>(map.values());
        }
    }
}
