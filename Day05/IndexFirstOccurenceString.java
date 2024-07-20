package Day05;

public class IndexFirstOccurenceString {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(haystack.length() < needle.length())
            {
                return -1;
            }
            int res = haystack.indexOf(needle);
            return res;
        }
    }
}
