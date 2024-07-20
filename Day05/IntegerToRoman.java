package Day05;

public class IntegerToRoman {
    class Solution {
        public String intToRoman(int num) {
            String M[] = {"", "M","MM", "MMM"};
            String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
            // the size of our array is 10, so to bring all the numbers between 0 t 10 where 10 is not inclusive, we will use (num % 10) which makes the number come in that range
            return M[(num/1000)%10] + C[(num/100)%10] + X[(num/10) % 10] + I[num % 10];
        }
    }
}
