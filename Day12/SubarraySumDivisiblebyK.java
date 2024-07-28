package Day12;

public class SubarraySumDivisiblebyK {
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {

            // APPROACH 01: - 

            // int count=0;
            // int n = nums.length;
            // int sum = 0;
            // int rem = 0;
    
            // HashMap<Integer, Integer> map = new HashMap<>();
            // map.put(0, 1);
        
            // for(int i=0; i<n; i++) {
            //     sum += nums[i];
            //     rem = sum % k;
    
            //     if(rem < 0) {
            //         rem += k;
            //     }
            //     if(map.containsKey(rem)) {
            //         count = count + map.get(rem);
            //         map.put(rem, map.get(rem) + 1);
            //     }
            //     else
            //     {
            //         map.put(rem, 1);
            //     }
            // }
            // return count;
    
            
            // APPROACH 02
            int count=0;
            int n = nums.length;
            int sum = 0;
            int rem = 0;
    
            int[] map = new int[k];
            map[0] = 1;
            for(int i=0; i<n; i++) {
                sum += nums[i];
                rem = sum % k;
    
                if(rem < 0) {
                    rem = rem % k + k;
                }
                count = count + map[rem];
                map[rem]++;
            }
            return count;
        }
    }
}
