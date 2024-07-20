package Day05;

public class ReverseWordsInString {
    class Solution {
        public String reverseWords(String s) {
            StringBuffer sb = new StringBuffer();
            // "\\s+" is a pattern that matches with one or more whitespace characters
           String[] arr = s.trim().split("\\s+");
            for(int i=arr.length-1; i>0; i--)
            {
                sb.append(arr[i] + " ");
            }
            return sb.toString() + arr[0];
        }
    }
}
