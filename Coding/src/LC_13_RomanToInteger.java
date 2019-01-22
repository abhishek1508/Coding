public class LC_13_RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int getValue(char roman) {
        switch(roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    private static int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            int first = getValue(s.charAt(i));
            if (i+1 != s.length()) {
                int second = getValue(s.charAt(i+1));
                if (first < second) {
                    sum = sum + (second - first);
                    i++;
                } else { sum = sum + first; }
            } else { sum = sum + first; }
            i++;
        }
        return sum;
    }
}
